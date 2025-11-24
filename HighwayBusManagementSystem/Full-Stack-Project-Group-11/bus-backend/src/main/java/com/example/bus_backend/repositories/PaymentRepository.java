package com.example.bus_backend.repositories;

import com.example.bus_backend.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}