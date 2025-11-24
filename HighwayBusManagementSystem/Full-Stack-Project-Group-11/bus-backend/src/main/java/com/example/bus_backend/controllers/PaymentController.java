package com.example.bus_backend.controllers;

import com.example.bus_backend.models.Payment;
import com.example.bus_backend.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) { this.service = service; }

    @PostMapping("/process")
    public ResponseEntity<?> process(@RequestBody Payment p) {
        return ResponseEntity.ok(service.processPayment(p));
    }

    @PostMapping("/{id}/verify-otp")
    public ResponseEntity<?> verifyOtp(@PathVariable String id, @RequestParam String otp) {
        return ResponseEntity.ok(service.verifyOtp(id, otp));
    }
}
