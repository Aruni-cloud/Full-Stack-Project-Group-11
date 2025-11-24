
/* package com.example.bus_backend.services;

import org.springframework.stereotype.Service;
import com.example.bus_backend.repositories.UserRepository;
import com.example.bus_backend.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Collections;

@Service
public class AuthService {
    private final UserRepository userRepo;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepo) { this.userRepo = userRepo; }

    public User register(String username, String email, String password) {
        if (userRepo.existsByUsername(username)) throw new RuntimeException("username taken");
        if (userRepo.existsByEmail(email)) throw new RuntimeException("email taken");
        User u = new User();
        u.setUsername(username);
        u.setEmail(email);
        u.setPasswordHash(passwordEncoder.encode(password));
        u.setRoles(Collections.singletonList("USER"));
        return userRepo.save(u);
    }

    // login will be handled by AuthController using JWT utilities
}
*/