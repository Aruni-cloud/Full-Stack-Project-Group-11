package com.example.bus_backend.Repository;

import com.example.bus_backend.Model.TicketPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketPriceRepository extends MongoRepository<TicketPrice, String> {
}
