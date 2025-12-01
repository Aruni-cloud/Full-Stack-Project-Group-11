package com.bus.busManagement.service;

import com.bus.busManagement.model.*;
import com.bus.busManagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverService {
    @Autowired private TripRepository tripRepository;
    @Autowired private BusRepository busRepository;

    public List<Trip> viewSchedules() {
        return tripRepository.findByStatus("SCHEDULED");
    }

    public List<Trip> viewRoutes() {
        // In this simple design, routes are derived from all trips
        return tripRepository.findAll();
    }

    public List<Bus> viewAssignedBus(String driverId) {
        return busRepository.findByDriverId(driverId);
    }
}
