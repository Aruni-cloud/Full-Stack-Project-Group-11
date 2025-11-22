package com.example.HighwayBusManagementSystem.Service.Impl;


import com.example.HighwayBusManagementSystem.Model.*;
import com.example.HighwayBusManagementSystem.Repository.*;
import org.springframework.stereotype.Service;
import com.example.HighwayBusManagementSystem.Service.PublicUserService;
import java.util.List;

@Service
public class PublicUserServiceImpl implements PublicUserService {

    private final AnnouncementRepository announcementRepo;
    private final ScheduleRepository scheduleRepo;
    private final RouteRepository routeRepo;
    private final TicketPriceRepository priceRepo;

    public PublicUserServiceImpl(
            AnnouncementRepository announcementRepo,
            ScheduleRepository scheduleRepo,
            RouteRepository routeRepo,
            TicketPriceRepository priceRepo
    ) {
        this.announcementRepo = announcementRepo;
        this.scheduleRepo = scheduleRepo;
        this.routeRepo = routeRepo;
        this.priceRepo = priceRepo;
    }

    @Override
    public List<Announcement> viewAnnouncements() {
        return announcementRepo.findAll();
    }

    @Override
    public List<Schedule> viewSchedules() {
        return scheduleRepo.findAll();
    }

    @Override
    public List<Route> viewRoutes() {
        return routeRepo.findAll();
    }

    @Override
    public List<TicketPrice> viewTicketPrices() {
        return priceRepo.findAll();
    }
}
