package com.example.HighwayBusManagementSystem.Service.Impl;

import org.springframework.stereotype.Service;
import com.example.HighwayBusManagementSystem.Security.PasswordEncoder;

import com.example.HighwayBusManagementSystem.Model.Admin;
import com.example.HighwayBusManagementSystem.Repository.AdminRepository;
import com.example.HighwayBusManagementSystem.Security.JwtUtil;
import com.example.HighwayBusManagementSystem.Service.AdminAuthService;

@Service
public class AdminAuthServiceImpl implements AdminAuthService {

    private final AdminRepository adminRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AdminAuthServiceImpl(AdminRepository adminRepository,
            JwtUtil jwtUtil,
            PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String register(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
        return "Admin Registered Successfully!";
    }

    @Override
    public String login(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);

        if (admin == null || !passwordEncoder.matches(password, admin.getPassword())) {
            return "Invalid username or password!";
        }

        return jwtUtil.generateToken(username, admin.getRole());
    }
}
