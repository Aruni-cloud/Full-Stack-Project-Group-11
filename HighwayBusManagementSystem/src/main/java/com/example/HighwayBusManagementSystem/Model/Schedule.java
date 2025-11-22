package com.example.HighwayBusManagementSystem.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "schedules")
public class Schedule {

    @Id
    private String id;
    private String busNo;
    private String departure;
    private String arrival;
    private String time;

    // getters & setters
}
