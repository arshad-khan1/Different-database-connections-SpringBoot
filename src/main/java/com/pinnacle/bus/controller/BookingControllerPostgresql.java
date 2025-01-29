package com.pinnacle.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinnacle.bus.model.BookingProstgresql;
import com.pinnacle.bus.service.BookingServicePostgresql;

@RestController
@RequestMapping("/api/postgresql/locations")
public class BookingControllerPostgresql {

    @Autowired
    private BookingServicePostgresql bookingService;

    // Create a new location
    @PostMapping
    public BookingProstgresql createLocation(@RequestBody BookingProstgresql location) {
        return bookingService.createLocation(location);
    }

    // Get location by ID
    @GetMapping("/{id}")
    public BookingProstgresql getLocationById(@PathVariable int id) {
        return bookingService.getLocationById(id);
    }

    // Get all locations
    @GetMapping
    public List<BookingProstgresql> getAllLocations() {
        return bookingService.getAllLocations();
    }

    // Delete location by ID
    @DeleteMapping("/{id}")
    public void deleteLocationById(@PathVariable int id) {
        bookingService.deleteLocationById(id);
    }
}
