package com.example.bus_backend.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "complaints")
public class Complaint {

    @Id
    private String id;

    private String userName;
    private String email;
    private String message;
    private String status; // Pending / Resolved
    private String date;
}
