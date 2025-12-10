package com.example.HighwayBusManagementSystem.Repository;

import com.example.HighwayBusManagementSystem.Model.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComplaintRepository extends MongoRepository<Complaint, String> {}
