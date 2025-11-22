package com.example.bus_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("payments")
public class Payment {
    @Id
    private String paymentID;
    private String bookingID;
    private double amount;
    private String paymentMethod; // CASH, CARD, MOBILE
    private Instant paymentDate;
    private String otp; // for simulation
    private String status; // PAID, FAILED, PENDING
    // getters & setters
}
