package com.example.bus_backend.Service;

import com.example.bus_backend.Model.Admin;

public interface AdminAuthService {
    String register(Admin admin);

    String login(String username, String password);

}
