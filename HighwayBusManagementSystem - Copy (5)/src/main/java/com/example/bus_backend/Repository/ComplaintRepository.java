package com.example.bus_backend.Repository;

import com.example.bus_backend.Model.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComplaintRepository extends MongoRepository<Complaint, String> {
}
