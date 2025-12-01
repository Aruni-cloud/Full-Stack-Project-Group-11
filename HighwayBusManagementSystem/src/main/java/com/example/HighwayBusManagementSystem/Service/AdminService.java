package com.example.HighwayBusManagementSystem.Service;

import java.util.List;

import com.example.HighwayBusManagementSystem.Model.Route;

public interface AdminService {
    Route addRoute(Route route);
    List<Route> getAllRoutes();
    void deleteRoute(String id);
}

