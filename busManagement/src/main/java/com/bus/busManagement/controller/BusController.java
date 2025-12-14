package com.bus.busManagement.controller;

import com.bus.busManagement.model.Bus;
import com.bus.busManagement.repository.BusRepository; // You might need to create this Repo too!
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
@CrossOrigin(origins = "*")
public class BusController {

    @Autowired
    private BusRepository busRepository;

    // 1. Add a new Bus
    @PostMapping("/add")
    public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
        return ResponseEntity.ok(busRepository.save(bus));
    }

    // 2. View all Buses
    @GetMapping("/all")
    public ResponseEntity<List<Bus>> getAllBuses() {
        return ResponseEntity.ok(busRepository.findAll());
    }

    // 3. Get Bus by Registration Number
    @GetMapping("/{regNo}")
    public ResponseEntity<?> getBus(@PathVariable String regNo) {
        // You would need to add findByRegistrationNumber in your Repository
        return ResponseEntity.ok("Bus details for " + regNo); 
    }
}