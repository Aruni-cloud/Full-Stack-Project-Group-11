package com.example.HighwayBusManagementSystem.Controller;

import com.example.HighwayBusManagementSystem.Model.*;
import com.example.HighwayBusManagementSystem.Service.PublicUserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/public")
@CrossOrigin("*")
public class PublicUserController {

    private final PublicUserService publicUserService;

    public PublicUserController(PublicUserService publicUserService) {
        this.publicUserService = publicUserService;
    }

    @GetMapping("/announcements")
    public List<Announcement> getAnnouncements() {
        return publicUserService.viewAnnouncements();
    }

    @GetMapping("/schedules")
    public List<Schedule> getSchedules() {
        return publicUserService.viewSchedules();
    }

    @GetMapping("/routes")
    public List<Route> getRoutes() {
        return publicUserService.viewRoutes();
    }

    @GetMapping("/ticket-prices")
    public List<TicketPrice> getTicketPrices() {
        return publicUserService.viewTicketPrices();
    }
}

