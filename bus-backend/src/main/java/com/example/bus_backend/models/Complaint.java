package com.example.bus_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("complaints")
public class Complaint {
    @Id
    private String complaintID;
    private String userID; // passengerID or admin/staff ID
    private String message;
    private String response;
    private Instant date;
    // getters & setters
}