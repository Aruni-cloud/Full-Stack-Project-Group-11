package com.example.bus_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("feedback")
public class Feedback {
    @Id
    private String feedbackID;
    private String passengerID;
    private String message;
    private int rating;
    private Instant date;
    private String response; // optional admin response
    
    public String getFeedbackID() { return feedbackID; }
public void setFeedbackID(String feedbackID) { this.feedbackID = feedbackID; }
public String getPassengerID() { return passengerID; }
public void setPassengerID(String passengerID) { this.passengerID = passengerID; }
public String getMessage() { return message; }
public void setMessage(String message) { this.message = message; }
public int getRating() { return rating; }
public void setRating(int rating) { this.rating = rating; }
public Instant getDate() { return date; }
public void setDate(Instant date) { this.date = date; }
public String getResponse() { return response; }
public void setResponse(String response) { this.response = response; }
}
