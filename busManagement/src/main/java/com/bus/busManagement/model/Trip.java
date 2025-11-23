package com.bus.system.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "trips")
public class Trip {
    @Id
    private String id;
    private String busId;
    private String routeName;
    private String startLocation;
    private String endLocation;
    private LocalDateTime startTime;
    private String status; // "SCHEDULED", "IN_PROGRESS", "COMPLETED"
    
    // Conductor updates these
    private int passengerCount; 
}
