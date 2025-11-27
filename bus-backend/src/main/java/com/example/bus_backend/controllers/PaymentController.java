package com.example.bus_backend.controllers;

import com.example.bus_backend.models.Payment;
import com.example.bus_backend.services.PaymentService;
import com.example.bus_backend.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*") // allow frontend/postman
public class PaymentController {

    private final PaymentService service;
    private final PaymentRepository repo;

    public PaymentController(PaymentService service, PaymentRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    // CREATE payment (POST)
    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return service.processPayment(payment);
    }

    // GET all payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return repo.findAll();
    }

    // GET payment by ID
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable String id) {
        return repo.findById(id).orElseThrow();
    }

    // DELETE payment by ID
    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable String id) {
        repo.deleteById(id);
        return "Payment deleted: " + id;
    }

    @PutMapping("/{id}")
public Payment updatePayment(@PathVariable String id, @RequestBody Payment updated) {

    Payment existing = repo.findById(id).orElseThrow();

    existing.setAmount(updated.getAmount());
    existing.setPaymentMethod(updated.getPaymentMethod());
    existing.setOtp(updated.getOtp());
    existing.setStatus(updated.getStatus());

    return repo.save(existing);
}

    // Verify OTP (POST)
    @PostMapping("/{id}/verify")
    public Payment verifyOtp(@PathVariable String id, @RequestParam String otp) {
        return service.verifyOtp(id, otp);
    }
}
