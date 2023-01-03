package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.exceptions.UserException;

import java.util.List;

public interface UserService {
    List<User> listUsers() throws UserException;
    User getUserById(Long userId) throws UserException;
    User addUser(User user) throws UserException;
    User editUser(User user) throws UserException;
    void removeUserById(Long userId) throws UserException;

}
