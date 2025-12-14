package com.example.bus_backend.services;

import com.example.bus_backend.models.Schedule;
import com.example.bus_backend.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository repo;
    public ScheduleService(ScheduleRepository repo) { this.repo = repo; }

    public Schedule addSchedule(Schedule s) { 
        if (s.getTotalSeats() != null && s.getAvailableSeats() == null) {
            s.setAvailableSeats(s.getTotalSeats());
        }
        return repo.save(s); 
    }
    public List<Schedule> findByRoute(String routeId) { return repo.findByRouteId(routeId); }
    public Optional<Schedule> findById(String id) { return repo.findById(id); }
    public List<Schedule> getAll() { return repo.findAll(); }
}
