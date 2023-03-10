package gg.astrub.astrub.web;

import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.exceptions.FileException;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
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
    @PostMapping("/users/addPhoto") /* Tested => OK */
    public String addUserProfilePhoto(@RequestParam(name = "userId") Long userId,
                                    @RequestParam(name = "profilePhoto") MultipartFile file,
                                    RedirectAttributes redirectAttributes) throws FileException, UserException, IOException {
        userService.setUserProfilePhoto(userId, file);
        redirectAttributes.addFlashAttribute("message", "File Upload Successful.");
        return "redirect:/";
    }
    @PostMapping("/users/addPhotoAsLOB") /* Tested => OK */
    public void addUserProfilePhotoAsLOB(@RequestParam(name = "userId") Long userId,
                                         @RequestParam(name = "profilePhoto") MultipartFile file) throws UserException, IOException {
        userService.setUserProfilePhotoAsLOB(userId, file);
    }
    @GetMapping("/users/getUserProfilePhoto") /* Tested => OK */
    public ResponseEntity<Resource> getUserProfilePhoto(@RequestParam(name = "userId") Long userId) throws Exception {
        Resource image = userService.getUserProfilePhoto(userId);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image);
    }
    @DeleteMapping("/users/removeUserById") /* Tested => OK */
    public void removeUserById(@RequestParam(name = "userId") Long userId) throws UserException {
        userService.removeUserById(userId);
    }
    @PatchMapping("/users/banUser") /* Tested => OK */
    public void banUserById(@RequestParam(name = "userId") Long userId) throws UserException {
        userService.banUserByID(userId);
    }
}
