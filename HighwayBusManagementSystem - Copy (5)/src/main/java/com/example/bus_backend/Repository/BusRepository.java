package com.example.bus_backend.Repository;

import com.example.bus_backend.Model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusRepository extends MongoRepository<Bus, String> {
}
