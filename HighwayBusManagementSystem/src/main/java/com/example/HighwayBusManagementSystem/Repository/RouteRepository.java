package com.example.HighwayBusManagementSystem.Repository;

import com.example.HighwayBusManagementSystem.Model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<Route, String> {}

