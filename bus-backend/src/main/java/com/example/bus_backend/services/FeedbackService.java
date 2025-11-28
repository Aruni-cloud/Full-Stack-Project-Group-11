package com.example.bus_backend.services;

import com.example.bus_backend.models.Feedback;
import com.example.bus_backend.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository repo;

    public FeedbackService(FeedbackRepository repo) {
        this.repo = repo;
    }

    // Create
    public Feedback submit(Feedback f) {
        f.setDate(Instant.now());
        return repo.save(f);
    }

    // Read by passenger
    public List<Feedback> findByPassenger(String passengerId) {
        return repo.findByPassengerID(passengerId);
    }

    // Read all
    public List<Feedback> getAll() {
        return repo.findAll();
    }

    // Update
    public Feedback updateFeedback(String id, Feedback updated) {
        Feedback f = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        if (updated.getMessage() != null) f.setMessage(updated.getMessage());
        if (updated.getRating() != 0) f.setRating(updated.getRating());
        if (updated.getResponse() != null) f.setResponse(updated.getResponse());

        return repo.save(f);
    }

    // Delete
    public void deleteFeedback(String id) {
        repo.deleteById(id);
    }
}

