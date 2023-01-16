package gg.astrub.astrub.web;

import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private UserServiceImpl userService;

    @GetMapping("/users")
    public List<User> getUsers() throws UserException {
        return userService.listUsers();
    }
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable Long userId) throws UserException {
        return userService.getUserById(userId);
    }
    @PostMapping("/users/addUser")
    public User addUser(@RequestBody User user) throws UserException {
        return userService.addUser(user);
    }
    @PutMapping("/users/editUser")
    public User editUser(@RequestBody User user) throws UserException {
        return userService.editUser(user);
    }
    @DeleteMapping("/users/removeUser/{userId}")
    public void removeUserById(@PathVariable Long userId) throws UserException {
        userService.removeUserById(userId);
    }
}
