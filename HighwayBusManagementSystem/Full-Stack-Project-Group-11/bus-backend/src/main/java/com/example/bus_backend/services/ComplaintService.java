package com.example.bus_backend.services;

import com.example.bus_backend.models.Complaint;
import com.example.bus_backend.repositories.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ComplaintService {
    private final ComplaintRepository repo;

    public ComplaintService(ComplaintRepository repo) { this.repo = repo; }

    public Complaint submit(Complaint c) {
        c.setDate(Instant.now());
        return repo.save(c);
    }

    public List<Complaint> findByUser(String userId) {
        return repo.findByUserID(userId);
    }
}
