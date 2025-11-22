package com.example.bus_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("passengers")
public class Passenger {
    @Id
    private String passengerId;
    private String name;
    private String email;
    private String password; // for student projects: plaintext is OK; in real projects hash it
    private String phoneNumber;

    // getters & setters
    // constructor(s)
}
