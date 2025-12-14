package com.example.bus_backend.Repository;

import com.example.bus_backend.Model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<Route, String> {
}
