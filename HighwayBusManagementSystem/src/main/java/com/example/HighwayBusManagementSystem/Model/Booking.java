package com.example.HighwayBusManagementSystem.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bookings")
public class Booking {

    @Id
    private String id;

    private String customerName;
    private String customerPhone;

    private String routeId;
    private String scheduleId;
    private String busId;
    private int seatsBooked;

    private double totalAmount;
    private String bookingDate;
    private String status; // Confirmed / Cancelled / Pending
}
