package com.example.HighwayBusManagementSystem.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "schedules")
public class Schedule {

    @Id
    private String id;
    private String busNo;
    private String departure;
    private String arrival;
    private String time;

        public String getId() {
        return id;
    }


    public String getBusNo() {
        return busNo;
    }


    public String getDeparture() {
        return departure;
    }


    public String getArrival() {
        return arrival;
    }

    public String getTime() {
        return time;
    }
    
}
