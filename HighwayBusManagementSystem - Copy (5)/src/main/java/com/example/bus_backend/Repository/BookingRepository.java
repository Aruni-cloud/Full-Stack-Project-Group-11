package com.example.bus_backend.Repository;

import com.example.bus_backend.Model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
