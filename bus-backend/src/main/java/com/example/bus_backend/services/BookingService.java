package com.example.bus_backend.services;

import com.example.bus_backend.models.Booking;
import com.example.bus_backend.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepo;

    public BookingService(BookingRepository bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public Booking createBooking(Booking b) {
        b.setBookingDate(Instant.now());
        b.setStatus("CONFIRMED");
        return bookingRepo.save(b);
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public List<Booking> getBookingsByPassenger(String passengerId) {
        return bookingRepo.findByPassengerID(passengerId);
    }

    public Optional<Booking> getBooking(String id) {
        return bookingRepo.findById(id);
    }

    public Booking cancelBooking(String id) {
        Booking b = bookingRepo.findById(id).orElseThrow();
        b.setStatus("CANCELLED");
        return bookingRepo.save(b);
    }

    public Booking modifyBooking(String id, Booking modified) {
        Booking b = bookingRepo.findById(id).orElseThrow();
        b.setSeatNumber(modified.getSeatNumber());
        b.setScheduleTime(modified.getScheduleTime());
        return bookingRepo.save(b);
    }

    public void deleteBooking(String id) {
        bookingRepo.deleteById(id);
    }
}

