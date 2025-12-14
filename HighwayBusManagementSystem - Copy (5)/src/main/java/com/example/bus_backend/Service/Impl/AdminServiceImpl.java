package com.example.bus_backend.Service.Impl;

import org.springframework.stereotype.Service;

import com.example.bus_backend.Service.AdminService;

import java.util.List;

import com.example.bus_backend.Model.Route;
import com.example.bus_backend.Repository.RouteRepository;

@Service
public class AdminServiceImpl implements AdminService {

    private final RouteRepository routeRepository;

    public AdminServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Route addRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public void deleteRoute(String id) {
        routeRepository.deleteById(id);
    }
}
