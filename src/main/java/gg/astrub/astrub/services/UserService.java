package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    User getUserById(Long userId);
    User addUser(User user);
    User editUser(Long userId);
    void removeUserById(Long userId);

}
