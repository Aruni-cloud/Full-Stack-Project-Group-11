package com.bus.busManagement.controller;

import com.bus.busManagement.model.Issue;
import com.bus.busManagement.repository.IssueRepository; // Create this Repo too!
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/issues")
@CrossOrigin(origins = "*")
public class IssueController {

    @Autowired
    private IssueRepository issueRepository;

    // 1. Report an Issue
    @PostMapping("/report")
    public ResponseEntity<Issue> reportIssue(@RequestBody Issue issue) {
        issue.setReportedAt(LocalDateTime.now()); // Auto-set the time
        return ResponseEntity.ok(issueRepository.save(issue));
    }

    // 2. View all Issues (For Admin)
    @GetMapping("/all")
    public ResponseEntity<List<Issue>> getAllIssues() {
        return ResponseEntity.ok(issueRepository.findAll());
    }
}