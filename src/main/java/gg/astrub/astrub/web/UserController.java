package gg.astrub.astrub.web;

import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Need to test every endpoint before Spring Security and Authentication */

@RestController
@AllArgsConstructor
public class UserController {
    private UserServiceImpl userService;

    @GetMapping("/users") /* Tested => OK */
    public List<User> getUsers() throws UserException {
        return userService.listUsers();
    }
    @GetMapping("/users/{userId}") /* Tested => OK */
    public User getUserById(@PathVariable Long userId) throws UserException {
        return userService.getUserById(userId);
    }
    @PostMapping("/users/addUser") /* Tested => OK */
    public void addUser(@RequestBody User user) throws UserException {
        userService.addUser(user);
    }
    @PatchMapping("/users/editUser") /* Tested => OK */
    public void editUser(@RequestBody User user) throws UserException {
        userService.editUser(user);
    }
    @DeleteMapping("/users/removeUser/{userId}")
    public void removeUserById(@PathVariable Long userId) throws UserException {
        userService.removeUserById(userId);
    }
    @PatchMapping("/users/banUser/{userId}")
    public void banUserById(@PathVariable Long userId) throws UserException {
        userService.banUserByID(userId);
    }
}
