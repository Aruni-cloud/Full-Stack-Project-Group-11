package com.example.bus_backend.Service;

import com.example.bus_backend.Model.*;
import java.util.List;

public interface PublicUserService {

    List<Announcement> viewAnnouncements();

    List<Schedule> viewSchedules();

    List<Route> viewRoutes();

    List<TicketPrice> viewTicketPrices();

    public List<Schedule> viewSchedulesByRoute(String departure, String arrival);

}