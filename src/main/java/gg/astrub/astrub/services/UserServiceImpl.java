package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

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
        if (userRepository.findById(user.getUserId()).isEmpty()) {
            throw new UserException("User With ID " + user.getUserId().toString() + " Doesn't Exist!");
        } else {
            return userRepository.save(user);
        }
//        User editedUser = userRepository.findById(user.getUserId()).orElseThrow(()-> new UserException("User Not Found!"));
//        editedUser.setUserName(user.getUserName());
//        editedUser.setUserEmail(user.getUserEmail());
//        editedUser.setUserPassword(user.getUserPassword());
//        editedUser.setUserBanned(user.isUserBanned());
//        userRepository.save(editedUser);
    }

    @Override
    public void setUserProfilePhoto(Long userId, String userProfilePhoto) throws UserException {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User Not Found!"));
        user.setUserProfilePicture(userProfilePhoto);
        userRepository.save(user);
    }

    @Override
    public void editUserProfilePhoto(Long userId, String userProfilePhoto) throws UserException {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User Not Found!"));
        user.setUserProfilePicture(userProfilePhoto);
        userRepository.save(user);
    }

    @Override
    public void removeUserById(Long userId) throws UserException {
        if (userRepository.findById(userId).isEmpty()) {
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
