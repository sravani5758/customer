package com.crm.crm.service;


import com.crm.crm.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    // Create
    User registerUser(String username, String email, String password, String role);

    // Read
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);

    // Update
    User updateUserRole(Long userId, String newRole);
    User updateUser(Long id, User userDetails);

    // Delete
    void deleteUser(Long userId);

    // Validation
    boolean usernameExists(String username);
    boolean emailExists(String email);

    // Authentication helpers
    boolean validatePassword(String rawPassword, String encodedPassword);
}