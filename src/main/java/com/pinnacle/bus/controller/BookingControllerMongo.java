package com.pinnacle.bus.controller;

import com.pinnacle.bus.model.BookingMongo;
import com.pinnacle.bus.service.BookingServiceMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo/bookings")
public class BookingControllerMongo {

    @Autowired
    private BookingServiceMongo bookingService;

    @PostMapping
    public BookingMongo createBooking(@RequestBody BookingMongo booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{id}")
    public BookingMongo getBooking(@PathVariable String id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping
    public List<BookingMongo> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable String id) {
        bookingService.deleteBookingById(id);
    }
}
