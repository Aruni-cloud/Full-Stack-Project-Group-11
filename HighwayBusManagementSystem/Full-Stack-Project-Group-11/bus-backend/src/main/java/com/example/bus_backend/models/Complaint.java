package com.example.bus_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("complaints")
public class Complaint {
    @Id
    private String complaintID;
    private String userID; // passengerID or admin/staff ID
    private String message;
    private String response;
    private Instant date;
    
    public String getComplaintID() { return complaintID; }
public void setComplaintID(String complaintID) { this.complaintID = complaintID; }
public String getUserID() { return userID; }
public void setUserID(String userID) { this.userID = userID; }
public String getMessage() { return message; }
public void setMessage(String message) { this.message = message; }
public String getResponse() { return response; }
public void setResponse(String response) { this.response = response; }
public Instant getDate() { return date; }
public void setDate(Instant date) { this.date = date; }
}