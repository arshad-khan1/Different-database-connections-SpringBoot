package com.pinnacle.bus.controller;

import com.pinnacle.bus.model.BookingMysql;
import com.pinnacle.bus.service.BookingServiceMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mysql/bookings")
public class BookingControllerMysql {

    @Autowired
    private BookingServiceMysql bookingService;

    @PostMapping
    public BookingMysql createBooking(@RequestBody BookingMysql booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{id}")
    public BookingMysql getBooking(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping
    public List<BookingMysql> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingService.deleteBookingById(id);
    }
}
