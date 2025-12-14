package com.example.bus_backend.controllers;

import java.util.List;

import com.example.bus_backend.models.Route;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bus_backend.services.AdminService;

@RestController
@RequestMapping("/api/admin/manage")
public class AdminManagementController {

    private final AdminService adminService;

    public AdminManagementController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/routes")
    public Route addRoute(@RequestBody Route route) {
        return adminService.addRoute(route);
    }

    @GetMapping("/routes")
    public List<Route> getRoutes() {
        return adminService.getAllRoutes();
    }

    @DeleteMapping("/routes/{id}")
    public String deleteRoute(@PathVariable String id) {
        adminService.deleteRoute(id);
        return "Route Deleted";
    }
}
