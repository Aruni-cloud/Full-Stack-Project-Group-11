package com.example.busmanagement1.controllers;

import com.example.busmanagement1.models.publicUser;
import com.example.busmanagement1.services.publicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public-users")
public class publicUserController {

    @Autowired
    private publicUserService publicUserService;

    @GetMapping
    public List<publicUser> getAllUsers() {
        return publicUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<publicUser> getUserById(@PathVariable Long id) {
        return publicUserService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public publicUser createUser(@RequestBody publicUser user) {
        return publicUserService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<publicUser> updateUser(@PathVariable Long id, @RequestBody publicUser userDetails) {
        try {
            publicUser updatedUser = publicUserService.updateUser(id, userDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        publicUserService.deleteUser(id);
         return ResponseEntity.noContent().build();
        
    }
}