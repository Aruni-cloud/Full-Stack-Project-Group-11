package com.example.HighwayBusManagementSystem.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "routes")
public class Route {

    @Id
    private String id;
    private String start;
    private String end;
    private double distance;

    public String getId() {
        return id;
    }


    public String getStart() {
        return start;
    }


    public String getEnd() {
        return end;
    }



    public double getDistance() {
        return distance;
    }


}

