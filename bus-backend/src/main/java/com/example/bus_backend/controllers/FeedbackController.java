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

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    // POST (Submit Feedback)
    @PostMapping("/submit")
    public ResponseEntity<?> submit(@RequestBody Feedback f) {
        return ResponseEntity.ok(service.submit(f));
    }

    // GET by Passenger ID
    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<List<Feedback>> byPassenger(@PathVariable String passengerId) {
        return ResponseEntity.ok(service.findByPassenger(passengerId));
    }

    // GET all
    @GetMapping("/all")
    public ResponseEntity<List<Feedback>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // PUT (Update feedback)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable String id,
            @RequestBody Feedback updatedFeedback) {
        return ResponseEntity.ok(service.updateFeedback(id, updatedFeedback));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.deleteFeedback(id);
        return ResponseEntity.ok("Feedback deleted successfully");
    }
}
