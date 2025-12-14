package com.example.bus_backend.repositories;

import com.example.bus_backend.models.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusRepository extends MongoRepository<Bus, String> {
}
