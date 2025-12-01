package com.bus.busManagement.service;

import com.bus.busManagement.model.User;
import com.bus.busManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired private UserRepository userRepository;

    public User register(User user) {
        // 1. Check Username
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Error: Username already exists!");
        }
        
        // 2. Check Email (Added this to match your Repository update)
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Error: Email is already in use!");
        }

        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }
        
        // Security measure: Clear password before returning to controller
        user.setPassword(null); 
        return user;
    }
}
