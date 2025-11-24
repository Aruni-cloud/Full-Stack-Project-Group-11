package com.example.bus_backend.controllers;

import com.example.bus_backend.models.Complaint;
import com.example.bus_backend.services.ComplaintService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {
    private final ComplaintService service;

    public ComplaintController(ComplaintService service) { this.service = service; }

    @PostMapping("/submit")
    public ResponseEntity<?> submit(@RequestBody Complaint c) {
        return ResponseEntity.ok(service.submit(c));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Complaint>> byUser(@PathVariable String userId) {
        return ResponseEntity.ok(service.findByUser(userId));
    }
}

