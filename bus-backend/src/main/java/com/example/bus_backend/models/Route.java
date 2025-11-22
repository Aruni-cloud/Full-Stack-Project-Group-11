package com.example.bus_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("routes")
public class Route {
    @Id
    private String routeId;
    private String startLocation;
    private String endLocation;
    private double distance;
    private double duration;
    // optionally list of schedule IDs or schedules inline
    // getters & setters
}