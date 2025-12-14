package com.example.bus_backend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "buses")
public class Bus {

    @Id
    private String id;

    private String busNumber;
    private String busType; // "AC", "Non-AC", "Luxury"
    private int totalSeats;
    private String status; // "Active", "Inactive", "In Maintenance"
}
