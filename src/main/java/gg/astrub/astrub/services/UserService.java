package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.exceptions.FileException;
import gg.astrub.astrub.exceptions.UserException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<User> listUsers() throws UserException;
    User getUserById(Long userId) throws UserException;
    User addUser(User user) throws UserException;
    User editUser(User user) throws UserException;
    void setUserProfilePhoto(Long userId, MultipartFile multipartFile) throws UserException, IOException, FileException;
    void removeUserById(Long userId) throws UserException;
    void banUserByID(Long userId) throws UserException;

}
