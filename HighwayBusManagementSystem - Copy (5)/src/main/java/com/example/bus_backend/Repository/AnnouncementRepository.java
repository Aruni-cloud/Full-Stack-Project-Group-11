package com.example.bus_backend.Repository;

import com.example.bus_backend.Model.Announcement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnnouncementRepository extends MongoRepository<Announcement, String> {
}
