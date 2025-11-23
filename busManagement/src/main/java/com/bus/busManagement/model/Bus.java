package com.bus.system.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "buses")
public class Bus {
    @Id
    private String id;
    private String registrationNumber;
    private String driverId;    // Assigned Driver
    private String conductorId; // Assigned Conductor
    private String routeName;   // Default route
}

