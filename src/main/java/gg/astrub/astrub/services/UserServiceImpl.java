package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.FileDB;
import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.exceptions.FileException;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.repositories.FileDBRepository;
import gg.astrub.astrub.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private FileDBRepository fileDBRepository;

    @Override
    public List<User> listUsers() throws UserException {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new UserException("List Of Users Not Found!");
        }
    }

    @Override
    public User getUserById(Long userId) throws UserException {
        return userRepository.findById(userId).orElseThrow(() -> new UserException("User Not Found"));
    }

    @Override
    public User addUser(User user) throws UserException {
        if (userRepository.findByUserEmail(user.getUserEmail())!=null) {
            throw new UserException("User Already Exists with the Email Address : " + user.getUserEmail());
        } else {
            User newUser = User.builder()
                    .userName(user.getUserName())
                    .userEmail(user.getUserEmail())
                    .userPassword(user.getUserPassword())
                    .userCreatedAt(new Date())
                    .userBanned(false)
                    .build();
            userRepository.save(newUser);
            return newUser;
        }
    }

    @Override
    public User editUser(User user) throws UserException {
        User userToEdit = userRepository.findById(user.getUserId()).orElseThrow(()-> new UserException("User Not Found !"));
        userToEdit.setUserName(user.getUserName());
        userToEdit.setUserEmail(user.getUserEmail());
        userToEdit.setUserPassword(user.getUserPassword());
        return userRepository.save(userToEdit);
//        User editedUser = userRepository.findById(user.getUserId()).orElseThrow(()-> new UserException("User Not Found!"));
//        editedUser.setUserName(user.getUserName());
//        editedUser.setUserEmail(user.getUserEmail());
//        editedUser.setUserPassword(user.getUserPassword());
//        editedUser.setUserBanned(user.isUserBanned());
//        userRepository.save(editedUser);
    }

    @Override // Uploading images as a file and saved in user/home dir
    public void setUserProfilePhoto(Long userId, MultipartFile multipartFile) throws UserException, IOException, FileException {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User Not Found !"));
        if (!multipartFile.isEmpty()) {
            String uploadDir = System.getProperty("user.home") + "/userProfilePhotos/" + user.getUserId() + "-" + user.getUserName() + "-" + multipartFile.getOriginalFilename();
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            try {
                multipartFile.transferTo(new File(uploadPath.toUri()));
            } catch (IOException ioException) {
                throw new IOException("Could not Save the file : " + multipartFile.toString(), ioException);
            }
            user.setUserProfilePicture(uploadDir);
            userRepository.save(user);
        } else {
            throw new FileException("File Not Found !");
        }
    }

    @Override // Uploading images as LOB and saving them in the DB
    public void setUserProfilePhotoAsLOB(Long userId, MultipartFile file) throws UserException, IOException {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User Not Found !"));
        FileDB fileDB = new FileDB();
        fileDB.setFileName(user.getUserId() + "-" + user.getUserName() + "-" + file.getOriginalFilename());
        String fileName = fileDB.getFileName();
        user.setUserProfilePicture(fileName);
        try {
            fileDB.setFileContent(file.getBytes());
        } catch (IOException ioException) {
            throw new IOException("Could not Save File :" + file.toString(), ioException);
        }
        fileDBRepository.save(fileDB);
    }

    @Override
    public Resource getUserProfilePhoto(Long userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User Not Found !"));
        String fileName = user.getUserProfilePicture();
        try {
            Resource profilePhoto = new FileSystemResource(fileName);
            return profilePhoto;
        } catch (Exception exception) {
            throw new Exception("Could Not Save File !", exception);
        }
    }

    @Override
    public void removeUserById(Long userId) throws UserException {
        if (userRepository.findById(userId).isEmpty()) {
            log.info("Stopped Here");
            throw new UserException("User Not Found !");
        } else {
            userRepository.deleteById(userId);
        }
    }

    @Override
    public void banUserByID(Long userId) throws UserException {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User Not Found!"));
        user.setUserBanned(true);
        userRepository.save(user);
    }
}
