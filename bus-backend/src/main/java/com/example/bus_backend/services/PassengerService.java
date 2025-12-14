package com.example.bus_backend.services;

import com.example.bus_backend.models.Passenger;
import com.example.bus_backend.repositories.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    private final PassengerRepository repo;

    public PassengerService(PassengerRepository repo) {
        this.repo = repo;
    }

    public Passenger register(Passenger p) {
        return repo.save(p);
    }

    public Passenger login(String email, String password) {
        Passenger p = repo.findByEmail(email);
        if (p != null && p.getPassword().equals(password)) {
            return p;
        }
        return null;
    }

    // ⭐ THIS WAS MISSING ⭐
    public Passenger findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public Optional<Passenger> findById(String id) {
        return repo.findById(id);
    }

    public List<Passenger> findAll() {
        return repo.findAll();
    }
}
