package com.example.busmanagement1.services;

import com.example.busmanagement1.models.publicUser;
import com.example.busmanagement1.repositories.publicUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class publicUserService {

    @Autowired
    private publicUserRepository publicUserRepository;

    public List<publicUser> getAllUsers() {
        return publicUserRepository.findAll();
    }

    public Optional<publicUser> getUserById(Long id) {
        return publicUserRepository.findById(id);
    }

    public publicUser createUser(publicUser user) {
        return publicUserRepository.save(user);
    }

    public publicUser updateUser(Long id, publicUser userDetails) {
        return publicUserRepository.findById(id).map(user -> {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return publicUserRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        publicUserRepository.deleteById(id);
    }
}
