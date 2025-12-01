package com.bus.busManagement.repository;

import com.bus.busManagement.model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BusRepository extends MongoRepository<Bus, String> {
    List<Bus> findByDriverId(String driverId);
    List<Bus> findByConductorId(String conductorId);
}
