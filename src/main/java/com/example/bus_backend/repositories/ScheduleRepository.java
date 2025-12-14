package com.example.bus_backend.repositories;

import com.example.bus_backend.models.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ScheduleRepository extends MongoRepository<Schedule, String> {
    List<Schedule> findByRouteId(String routeId);

    List<Schedule> findByDepartureAndArrival(String departure, String arrival);
}