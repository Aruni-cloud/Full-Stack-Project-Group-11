package com.example.bus_backend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "trips")
public class Trip {

    @Id
    private String id;

    private String busId;
    private String driverId;
    private String routeId;
    private String scheduleId;

    private String tripDate;
    private String status; // Completed / Ongoing / Upcoming / Cancelled
}
