package com.bus.system.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    
    @Indexed(unique = true)
    private String username;
    
    @Indexed(unique = true) // Good practice to ensure unique emails
    private String email;   // <--- ADDED THIS BACK
    
    private String password;
    private String role;     // "DRIVER" or "CONDUCTOR"
    private String fullName;
}
