package com.example.bus_backend.controllers;

import com.example.bus_backend.models.Feedback;
import com.example.bus_backend.services.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    private final FeedbackService service;

    public FeedbackController(FeedbackService service) { this.service = service; }

    @PostMapping("/submit")
    public ResponseEntity<?> submit(@RequestBody Feedback f) {
        return ResponseEntity.ok(service.submit(f));
    }

    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<List<Feedback>> byPassenger(@PathVariable String passengerId) {
        return ResponseEntity.ok(service.findByPassenger(passengerId));
    }
}
