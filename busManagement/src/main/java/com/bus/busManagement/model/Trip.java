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
    
    // Renamed 'startTime' to 'scheduleTime' to match previous Service logic
    private LocalDateTime scheduleTime; 
    
    private String status; // "SCHEDULED", "IN_PROGRESS", "COMPLETED"
    private int passengerCount; 
}
12th