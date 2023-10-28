package com.fot.hms.controller;

import com.fot.hms.model.UsersEntity;
import com.fot.hms.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    public UsersEntity createUser(@RequestBody UsersEntity user) {
        return userService.createUser(user);
    }

    // Get all users
    @GetMapping("/all")
    public List<UsersEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public UsersEntity getUserById(@PathVariable int id) {
        return userService.getUserById(id).orElse(null);
    }

    // Update a user
    @PutMapping("/update")
    public UsersEntity updateUser(@RequestBody UsersEntity user) {
        return userService.updateUser(user);
    }

    // Delete a user
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    // Create a user with encrypted password
    @PostMapping("/createWithEncryptedPassword")
    public int createUserWithEncryptedPassword(@RequestBody Map<String, Object> requestData) {
        String indexNo = (String) requestData.get("indexNo");
        String name = (String) requestData.get("name");
        String email = (String) requestData.get("email");
        String mobileNo = (String) requestData.get("mobileNo");
        String password = (String) requestData.get("password");
        int role = (int) requestData.get("role");

        int res = userService.createUserWithEncryptedPassword(indexNo, name, email, mobileNo, password, role);



        return res;
    }

    @PostMapping("/authenticate")
    public Map<String, Object> authenticateUser(@RequestBody Map<String, String> requestData) {
        String identifier = requestData.get("identifier");
        String password = requestData.get("password");

        return userService.authenticateUser(identifier, password);
    }

}
