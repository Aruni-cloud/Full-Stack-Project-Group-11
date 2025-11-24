package com.example.bus_backend.repositories;

import com.example.bus_backend.models.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerRepository extends MongoRepository<Passenger, String> {
    Passenger findByEmail(String email);
}
