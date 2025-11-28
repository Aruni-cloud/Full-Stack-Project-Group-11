package com.example.bus_backend.controllers;

import com.example.bus_backend.models.Schedule;
import com.example.bus_backend.services.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController(ScheduleService service) { this.service = service; }

    // CREATE
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Schedule s) {
        return ResponseEntity.ok(service.addSchedule(s));
    }

    // READ - All schedules
    @GetMapping
    public ResponseEntity<?> all() {
        return ResponseEntity.ok(service.getAll());
    }

    // READ - By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // READ - By Route
    @GetMapping("/route/{routeId}")
    public ResponseEntity<List<Schedule>> byRoute(@PathVariable String routeId) {
        return ResponseEntity.ok(service.findByRoute(routeId));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Schedule updated) {
        return ResponseEntity.ok(service.update(id, updated));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok("Schedule Deleted");
    }
}
