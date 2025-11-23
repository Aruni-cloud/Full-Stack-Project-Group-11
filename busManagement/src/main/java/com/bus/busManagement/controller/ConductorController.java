package com.bus.system.controller;

import com.bus.system.model.*;
import com.bus.system.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/conductor")
@CrossOrigin(origins = "*")
public class ConductorController {

    @Autowired private ConductorService conductorService;

    // --- Trip Status ---
    @PutMapping("/trip/status/{tripId}")
    public ResponseEntity<Trip> updateTripStatus(@PathVariable String tripId, @RequestParam String status) {
        return ResponseEntity.ok(conductorService.updateTripStatus(tripId, status));
    }

    // --- Issues (Handles both Vehicle and Route issues) ---
    @PostMapping("/issue")
    public ResponseEntity<Issue> reportIssue(@RequestBody Issue issue) {
        // Frontend sends: { "type": "VEHICLE" ... } or { "type": "ROUTE" ... }
        return ResponseEntity.ok(conductorService.reportIssue(issue));
    }

    // --- Passenger Data ---
    @PutMapping("/trip/passengers/{tripId}")
    public ResponseEntity<Trip> recordPassengerData(@PathVariable String tripId, @RequestParam int count) {
        return ResponseEntity.ok(conductorService.recordPassengerData(tripId, count));
    }

    // --- Views ---
    @GetMapping("/history")
    public ResponseEntity<List<Trip>> viewTripHistory() {
        return ResponseEntity.ok(conductorService.viewTripHistory());
    }

    @GetMapping("/bus/{conductorId}")
    public ResponseEntity<List<Bus>> viewAssignedBus(@PathVariable String conductorId) {
        return ResponseEntity.ok(conductorService.viewAssignedBus(conductorId));
    }

    @GetMapping("/announcements")
    public ResponseEntity<List<String>> viewAnnouncements() {
        return ResponseEntity.ok(conductorService.viewAnnouncements());
    }
    
    // Reusing Logic for Schedules/Routes
    @GetMapping("/schedules")
    public ResponseEntity<List<Trip>> viewSchedules() {
        // Conductor sees same schedule list as driver
        return ResponseEntity.ok(conductorService.viewTripHistory()); // Logic can be adjusted to viewSchedules
    }

    @GetMapping("/routes")
    public ResponseEntity<List<Trip>> viewRoutes() {
        return ResponseEntity.ok(conductorService.viewTripHistory());
    }
}
