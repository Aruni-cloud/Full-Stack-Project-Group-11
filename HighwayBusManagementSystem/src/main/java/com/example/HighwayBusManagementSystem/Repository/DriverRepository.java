package com.example.HighwayBusManagementSystem.Repository;

import com.example.HighwayBusManagementSystem.Model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<Driver, String> {}
