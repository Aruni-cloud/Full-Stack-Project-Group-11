package com.example.bus_backend.repositories;

import com.example.bus_backend.models.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByPassengerID(String passengerID);
    List<Booking> findByScheduleId(String scheduleId);
}