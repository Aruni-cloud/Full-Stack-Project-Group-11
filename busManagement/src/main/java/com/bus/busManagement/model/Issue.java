package com.bus.system.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "issues")
public class Issue {
    @Id
    private String id;
    private String type; // "VEHICLE" or "ROUTE"
    private String description;
    private String reportedByUserId;
    private LocalDateTime reportedAt;
}
