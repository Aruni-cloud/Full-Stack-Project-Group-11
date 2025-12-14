package com.example.bus_backend.Repository;

import com.example.bus_backend.Model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<Driver, String> {
}
