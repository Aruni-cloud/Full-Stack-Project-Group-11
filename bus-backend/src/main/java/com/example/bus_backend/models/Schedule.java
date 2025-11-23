package com.example.bus_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("schedules")
public class Schedule {
    @Id
    private String scheduleId;
    private String routeId;
    private String busId; // optional
    private Instant departureTime;
    private Instant arrivalTime;
    private String frequency;
    private int availableSeats;

public String getScheduleId() { return scheduleId; }
public void setScheduleId(String scheduleId) { this.scheduleId = scheduleId; }
public String getRouteId() { return routeId; }
public void setRouteId(String routeId) { this.routeId = routeId; }
public String getBusId() { return busId; }
public void setBusId(String busId) { this.busId = busId; }
public Instant getDepartureTime() { return departureTime; }
public void setDepartureTime(Instant departureTime) { this.departureTime = departureTime; }
public Instant getArrivalTime() { return arrivalTime; }
public void setArrivalTime(Instant arrivalTime) { this.arrivalTime = arrivalTime; }
public String getFrequency() { return frequency; }
public void setFrequency(String frequency) { this.frequency = frequency; }
public int getAvailableSeats() { return availableSeats; }
public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
}