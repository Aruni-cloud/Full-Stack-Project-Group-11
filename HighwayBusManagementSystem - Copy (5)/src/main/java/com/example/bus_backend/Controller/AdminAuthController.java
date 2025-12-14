package com.example.bus_backend.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bus_backend.Model.Admin;
import com.example.bus_backend.Service.AdminAuthService;

@RestController
@RequestMapping("/api/admin/auth")
public class AdminAuthController {

    private final AdminAuthService adminAuthService;

    public AdminAuthController(AdminAuthService adminAuthService) {
        this.adminAuthService = adminAuthService;
    }

    @PostMapping("/register")
    public String register(@RequestBody Admin admin) {
        return adminAuthService.register(admin);
    }

    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {
        return adminAuthService.login(admin.getUsername(), admin.getPassword());
    }
}
