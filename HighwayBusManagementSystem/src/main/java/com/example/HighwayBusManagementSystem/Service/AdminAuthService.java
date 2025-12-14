package com.example.HighwayBusManagementSystem.Service;

import com.example.HighwayBusManagementSystem.Model.Admin;

public interface AdminAuthService {
    String register(Admin admin);
    String login(String username, String password);
    
}
