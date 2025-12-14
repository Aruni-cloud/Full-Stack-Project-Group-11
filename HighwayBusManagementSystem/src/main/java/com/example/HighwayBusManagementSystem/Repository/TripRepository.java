package com.example.HighwayBusManagementSystem.Repository;

import com.example.HighwayBusManagementSystem.Model.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository extends MongoRepository<Trip, String> {}
