package com.example.HighwayBusManagementSystem.Repository;

import com.example.HighwayBusManagementSystem.Model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {}
