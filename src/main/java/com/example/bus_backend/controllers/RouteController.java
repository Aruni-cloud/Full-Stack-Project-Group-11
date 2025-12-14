package com.example.bus_backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bus_backend.models.Route;
import com.example.bus_backend.repositories.RouteRepository;
import com.example.bus_backend.services.AdminService;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final AdminService adminService;
    private final RouteRepository routeRepository;

    public RouteController(AdminService adminService, RouteRepository routeRepository) {
        this.adminService = adminService;
        this.routeRepository = routeRepository;
    }

    @GetMapping
    public List<Route> getAll() {
        return adminService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getById(@PathVariable String id) {
        Optional<Route> r = routeRepository.findById(id);
        return r.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Route> create(@RequestBody Route route) {
        Route saved = adminService.addRoute(route);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> update(@PathVariable String id, @RequestBody Route route) {
        Optional<Route> existing = routeRepository.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Route e = existing.get();
        e.setStartLocation(route.getStartLocation());
        e.setEnd(route.getEnd());
        e.setDistance(route.getDistance());

        Route saved = routeRepository.save(e);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        adminService.deleteRoute(id);
        return ResponseEntity.noContent().build();
    }
}
