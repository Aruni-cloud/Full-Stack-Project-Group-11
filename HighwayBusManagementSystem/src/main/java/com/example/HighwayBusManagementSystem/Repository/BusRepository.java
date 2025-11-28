package com.example.HighwayBusManagementSystem.Repository;

import com.example.HighwayBusManagementSystem.Model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusRepository extends MongoRepository<Bus, String> {}
