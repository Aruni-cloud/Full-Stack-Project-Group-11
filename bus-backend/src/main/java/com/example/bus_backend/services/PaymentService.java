package com.example.bus_backend.services;

import com.example.bus_backend.models.Payment;
import com.example.bus_backend.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository repo;

    public PaymentService(PaymentRepository repo) {
        this.repo = repo;
    }

    public Payment processPayment(Payment p) {
        p.setPaymentID(UUID.randomUUID().toString());
        p.setPaymentDate(Instant.now());
        p.setStatus("PAID");
        return repo.save(p);
    }

    public Payment verifyOtp(String paymentId, String otp) {
        Payment p = repo.findById(paymentId).orElseThrow();
        if (p.getOtp() != null && p.getOtp().equals(otp)) {
            p.setStatus("PAID");
        } else {
            p.setStatus("FAILED");
        }
        return repo.save(p);
    }
}
