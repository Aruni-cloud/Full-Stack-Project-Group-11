package com.example.busmanagement1.controllers;

import com.example.busmanagement1.models.registeredUser;
import com.example.busmanagement1.services.registeredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registered-users")
public class registeredUserController {

    @Autowired
    private registeredUserService registeredUserService;

    @GetMapping
    public List<registeredUser> getAllUsers() {
        return registeredUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<registeredUser> getUserById(@PathVariable Long id) {
        return registeredUserService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public registeredUser createUser(@RequestBody registeredUser user) {
        return registeredUserService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<registeredUser> updateUser(@PathVariable Long id, @RequestBody registeredUser userDetails) {
        try {
            registeredUser updatedUser = registeredUserService.updateUser(id, userDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        registeredUserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
