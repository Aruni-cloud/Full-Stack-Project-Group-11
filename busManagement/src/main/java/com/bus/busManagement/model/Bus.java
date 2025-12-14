package com.bus.busManagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "buses")
public class Bus {
    @Id
    private String id;
    
    // Ensure your frontend uses "registrationNumber", not "regNumber"
    private String registrationNumber; 
    
    private String driverId;
    private String conductorId;
    private String routeName;
}
