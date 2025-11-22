package com.example.HighwayBusManagementSystem.Repository;

import com.example.HighwayBusManagementSystem.Model.TicketPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketPriceRepository extends MongoRepository<TicketPrice, String> {}
