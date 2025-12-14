package com.example.bus_backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.bus_backend.models.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {

    Admin findByUsername(String username);
}