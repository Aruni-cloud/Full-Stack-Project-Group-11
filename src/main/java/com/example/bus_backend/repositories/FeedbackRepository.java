package com.example.bus_backend.repositories;

import com.example.bus_backend.models.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {
    List<Feedback> findByPassengerID(String passengerID);
}
