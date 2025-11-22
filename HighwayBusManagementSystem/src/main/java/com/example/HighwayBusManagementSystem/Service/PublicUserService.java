package com.example.HighwayBusManagementSystem.Service;

import com.example.HighwayBusManagementSystem.Model.*;
import java.util.List;

public interface PublicUserService {

    List<Announcement> viewAnnouncements();

    List<Schedule> viewSchedules();

    List<Route> viewRoutes();

    List<TicketPrice> viewTicketPrices();
}