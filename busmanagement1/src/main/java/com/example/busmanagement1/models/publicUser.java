package com.example.busmanagement1.models;
import jakarta.persistence.*;

@Entity
@Table(name = "public_users")
public class publicUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    // Constructors
    public publicUser() {}

    public publicUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters & Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

