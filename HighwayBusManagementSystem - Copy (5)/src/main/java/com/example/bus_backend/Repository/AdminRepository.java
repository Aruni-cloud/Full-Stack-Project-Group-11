package com.example.bus_backend.Repository;

import com.example.bus_backend.Model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String> {

    Admin findByUsername(String username);
}
