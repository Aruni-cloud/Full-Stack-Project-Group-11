package com.example.bus_backend.services;

import com.example.bus_backend.models.Complaint;
import com.example.bus_backend.repositories.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository repo;

    public ComplaintService(ComplaintRepository repo) {
        this.repo = repo;
    }

    public Complaint submit(Complaint c) {
        c.setDate(Instant.now());
        return repo.save(c);
    }

    public List<Complaint> getAll() {
        return repo.findAll();
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

    public Complaint updateResponse(String id, String response) {
        Complaint c = repo.findById(id).orElseThrow();
        c.setResponse(response);
        return repo.save(c);
    }

    public List<Complaint> findByUser(String userId) {
        return repo.findByUserId(userId);  // ✅ FIXED
    }
}
