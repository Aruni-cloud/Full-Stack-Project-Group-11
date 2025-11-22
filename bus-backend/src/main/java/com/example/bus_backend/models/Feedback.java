package com.example.bus_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("feedback")
public class Feedback {
    @Id
    private String feedbackID;
    private String passengerID;
    private String message;
    private int rating;
    private Instant date;
    private String response; // optional admin response
    // getters & setters
}
