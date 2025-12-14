package com.example.busmanagement1.services;

import com.example.busmanagement1.models.registeredUser;
import com.example.busmanagement1.repositories.registeredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class registeredUserService {

    @Autowired
    private registeredUserRepository registeredUserRepository;

    public List<registeredUser> getAllUsers() {
        return registeredUserRepository.findAll();
    }

    public Optional<registeredUser> getUserById(Long id) {
        return registeredUserRepository.findById(id);
    }

    public registeredUser createUser(registeredUser user) {
        return registeredUserRepository.save(user);
    }

    public registeredUser updateUser(Long id, registeredUser userDetails) {
        return registeredUserRepository.findById(id).map(user -> {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            return registeredUserRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        registeredUserRepository.deleteById(id);
    }
}
