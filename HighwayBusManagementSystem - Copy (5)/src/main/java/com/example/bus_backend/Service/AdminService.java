package com.example.bus_backend.Service;

import java.util.List;

import com.example.bus_backend.Model.Route;

public interface AdminService {
    Route addRoute(Route route);

    List<Route> getAllRoutes();

    void deleteRoute(String id);
}
