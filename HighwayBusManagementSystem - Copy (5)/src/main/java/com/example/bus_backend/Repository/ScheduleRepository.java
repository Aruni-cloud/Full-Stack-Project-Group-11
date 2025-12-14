package com.example.bus_backend.Repository;

import com.example.bus_backend.Model.Schedule;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScheduleRepository extends MongoRepository<Schedule, String> {
    List<Schedule> findByDepartureAndArrival(String departure, String arrival);
}