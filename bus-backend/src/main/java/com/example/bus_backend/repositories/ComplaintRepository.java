package com.example.bus_backend.repositories;

import com.example.bus_backend.models.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ComplaintRepository extends MongoRepository<Complaint, String> {
    List<Complaint> findByUserID(String userID);
}
