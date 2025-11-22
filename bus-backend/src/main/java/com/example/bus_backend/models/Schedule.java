package com.example.bus_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("schedules")
public class Schedule {
    @Id
    private String scheduleId;
    private String routeId;
    private String busId; // optional
    private Instant departureTime;
    private Instant arrivalTime;
    private String frequency;
    // getters & setters
}