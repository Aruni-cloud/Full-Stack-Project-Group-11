package com.example.bus_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("bookings")
public class Booking {
    @Id
private String bookingID;
private String passengerID;
private String scheduleId;
private Instant scheduleTime;
private int seatNumber;
private Instant bookingDate;
private String status;


public String getBookingID() { return bookingID; }
public void setBookingID(String bookingID) { this.bookingID = bookingID; }
public String getPassengerID() { return passengerID; }
public void setPassengerID(String passengerID) { this.passengerID = passengerID; }
public String getScheduleId() { return scheduleId; }
public void setScheduleId(String scheduleId) { this.scheduleId = scheduleId; }
public Instant getScheduleTime() { return scheduleTime; }
public void setScheduleTime(Instant scheduleTime) { this.scheduleTime = scheduleTime; }
public int getSeatNumber() { return seatNumber; }
public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }
public Instant getBookingDate() { return bookingDate; }
public void setBookingDate(Instant bookingDate) { this.bookingDate = bookingDate; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
}
