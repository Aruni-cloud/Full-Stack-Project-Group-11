package com.example.bus_backend.repositories;

import com.example.bus_backend.models.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<Route, String> {
}
