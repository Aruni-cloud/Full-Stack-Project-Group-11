package com.example.bus_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.bus_backend.models.Passenger;
import com.example.bus_backend.services.PassengerService;

@SpringBootApplication
public class BusBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusBackendApplication.class, args);
    }

    // This will run after the app starts and insert a test passenger
    @Bean
    CommandLineRunner init(PassengerService service) {
        return args -> {
            // Check if test passenger already exists
            Passenger existing = service.findByEmail("test@example.com");
            if (existing == null) {
                Passenger p = new Passenger();
                p.setName("Test User");
                p.setEmail("test@example.com");
                p.setPassword("123456");
                p.setPhoneNumber("1234567890");
                service.register(p);
                System.out.println("Test passenger created and database initialized.");
            } else {
                System.out.println("Test passenger already exists.");
            }
        };
    }
}
