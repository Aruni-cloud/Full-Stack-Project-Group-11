package com.example.bus_backend.controllers;

import com.example.bus_backend.models.Passenger;
import com.example.bus_backend.services.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
    private final PassengerService service;

    public PassengerController(PassengerService service) { this.service = service; }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Passenger p) {
        if (service.findByEmail(p.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already used");
        }
        Passenger saved = service.register(p);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Passenger req) {
        Passenger p = service.findByEmail(req.getEmail());
        if (p == null) return ResponseEntity.status(404).body("user not found");
        if (!p.getPassword().equals(req.getPassword())) return ResponseEntity.status(401).body("invalid credentials");
        return ResponseEntity.ok(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        Optional<Passenger> p = service.findById(id);
        return p.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
