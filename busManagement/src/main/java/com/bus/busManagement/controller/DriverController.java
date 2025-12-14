package com.bus.busManagement.controller;

import com.bus.busManagement.model.Bus;
import com.bus.busManagement.model.Trip;
import com.bus.busManagement.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/driver")
@CrossOrigin(origins = "*")
public class DriverController {

    @Autowired private DriverService driverService;

    @GetMapping("/schedules")
    public ResponseEntity<List<Trip>> viewSchedules() {
        return ResponseEntity.ok(driverService.viewSchedules());
    }

    @GetMapping("/routes")
    public ResponseEntity<List<Trip>> viewRoutes() {
        return ResponseEntity.ok(driverService.viewRoutes());
    }

    @GetMapping("/bus/{driverId}")
    public ResponseEntity<List<Bus>> viewAssignedBus(@PathVariable String driverId) {
        return ResponseEntity.ok(driverService.viewAssignedBus(driverId));
    }
}
