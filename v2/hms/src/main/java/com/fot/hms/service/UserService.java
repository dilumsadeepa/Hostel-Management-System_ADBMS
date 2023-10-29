package com.fot.hms.service;

import com.fot.hms.model.UsersEntity;
import com.fot.hms.repo.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // Create operation
    public UsersEntity createUser(UsersEntity user) {
        return userRepo.save(user);
    }

    // Read operation
    public List<UsersEntity> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<UsersEntity> getUserById(int id) {
        return userRepo.findById(id);
    }

    // Update operation
    public UsersEntity updateUser(UsersEntity user) {
        return userRepo.save(user);
    }

    // Delete operation
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public String createUserWithEncryptedPassword(String indexNo, String name, String email, String mobileNo, String password, int role) {
        String res = userRepo.createUserWithEncryptedPassword(indexNo, name, email, mobileNo, password, role);
        return res;
    }

    public Map<String, Object> authenticateUser(String identifier, String password) {
        List<Map<String, Object>> result = userRepo.authenticateUser(identifier, password);

        Map<String, Object> response = new HashMap<>();
        if (!result.isEmpty()) {
            response.put("message", "Authentication Successful");
            response.putAll(result.get(0)); // Assuming it returns a single row with user details
        } else {
            response.put("message", "Authentication Failed");
        }
        return response;
    }

    @Transactional
    public List<Map<String, Object>> updateUserWithProcedure(int id, String indexNo, String name, String email, String mobileNo, String password, int role) {

        return userRepo.updateUser(id, indexNo, name, email, mobileNo, password, role);
    }

}
