package com.example.HighwayBusManagementSystem.Repository;

import com.example.HighwayBusManagementSystem.Model.Schedule;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface ScheduleRepository extends MongoRepository<Schedule, String> {
    List<Schedule> findByDepartureAndArrival(String departure, String arrival);
}