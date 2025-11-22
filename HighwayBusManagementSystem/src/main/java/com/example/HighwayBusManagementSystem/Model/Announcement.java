package com.example.HighwayBusManagementSystem.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "announcements")
public class Announcement {

    @Id
    private String id;
    private String title;
    private String message;
    private String date;

    // getters & setters
}
