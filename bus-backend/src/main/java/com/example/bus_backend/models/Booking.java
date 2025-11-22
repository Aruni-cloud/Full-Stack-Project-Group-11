package com.example.bus_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("bookings")
public class Booking {
    @Id
    private String bookingID;
    private String passengerID;
    private String scheduleId;
    private Instant scheduleTime; // or departure time
    private int seatNumber;
    private Instant bookingDate;
    private String status; // e.g., CONFIRMED, CANCELLED
    // getters & setters
}
