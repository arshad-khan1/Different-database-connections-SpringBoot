package com.pinnacle.bus.controller;

import com.pinnacle.bus.model.Booking;
import com.pinnacle.bus.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable String id){
        return bookingService.getBookingById(id);
    }
    
    @GetMapping("/delete/{id}")
    public void deleteBooking(@PathVariable String id){
        bookingService.deleteBooking(id);
    }

    @PostMapping("/save")
    public Booking addBooking(@RequestBody Booking booking){
        return bookingService.addBooking(booking);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<String> updateBooking(@PathVariable String id, @RequestBody Booking booking){
        bookingService.updateBooking(id, booking);
        return ResponseEntity.ok("Booking updated successfully");
    }
}

