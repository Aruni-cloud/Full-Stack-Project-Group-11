package com.example.bus_backend.services;

import com.example.bus_backend.models.Feedback;
import com.example.bus_backend.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository repo;

    public FeedbackService(FeedbackRepository repo) { this.repo = repo; }

    public Feedback submit(Feedback f) {
        f.setDate(Instant.now());
        return repo.save(f);
    }

    public List<Feedback> findByPassenger(String passengerId) {
        return repo.findByPassengerID(passengerId);
    }
}
