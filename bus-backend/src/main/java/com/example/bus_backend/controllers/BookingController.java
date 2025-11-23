package com.example.bus_backend.controllers;

import com.example.bus_backend.models.Booking;
import com.example.bus_backend.services.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;


import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService service;

    public BookingController(BookingService service) { this.service = service; }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Booking b) {
        try {
            Booking saved = service.createBooking(b);
            return ResponseEntity.ok(saved);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<List<Booking>> getByPassenger(@PathVariable String passengerId) {
        return ResponseEntity.ok(service.getBookingsByPassenger(passengerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBooking(@PathVariable String id) {
        return service.getBooking(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<?> cancel(@PathVariable String id) {
        return ResponseEntity.ok(service.cancelBooking(id));
    }

    @PutMapping("/{id}/modify")
    public ResponseEntity<?> modify(@PathVariable String id, @RequestBody Booking modified) {
        return ResponseEntity.ok(service.modifyBooking(id, modified));
    }

    @GetMapping("/{id}/print")
    public ResponseEntity<?> printTicket(@PathVariable String id) {
        return service.getBooking(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

