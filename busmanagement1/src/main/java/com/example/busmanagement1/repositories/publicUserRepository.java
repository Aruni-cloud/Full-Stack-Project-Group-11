package com.example.busmanagement1.repositories;

import com.example.busmanagement1.models.publicUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface publicUserRepository extends JpaRepository<publicUser, Long> {
    Optional<publicUser> findByEmail(String email);
}