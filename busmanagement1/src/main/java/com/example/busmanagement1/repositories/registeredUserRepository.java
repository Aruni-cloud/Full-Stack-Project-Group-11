package com.example.busmanagement1.repositories;

import com.example.busmanagement1.models.registeredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface registeredUserRepository extends JpaRepository<registeredUser, Long> {
    Optional<registeredUser> findByEmail(String email);
    Optional<registeredUser> findByPhoneNumber(String phoneNumber);
}
