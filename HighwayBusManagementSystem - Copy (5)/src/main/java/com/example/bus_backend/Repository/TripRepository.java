package com.example.bus_backend.Repository;

import com.example.bus_backend.Model.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository extends MongoRepository<Trip, String> {
}
