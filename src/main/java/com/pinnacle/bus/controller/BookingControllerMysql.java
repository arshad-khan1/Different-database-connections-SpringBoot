package com.pinnacle.bus.controller;

import com.pinnacle.bus.model.BookingMySQL;
import com.pinnacle.bus.service.BookingServiceMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mysql/vehicles")
public class BookingControllerMysql {

    @Autowired
    private BookingServiceMysql bookingService;

    // Create a new vehicle
    @PostMapping
    public BookingMySQL createVehicle(@RequestBody BookingMySQL vehicle) {
        return bookingService.createVehicle(vehicle);
    }

    // Get vehicle by ID
    @GetMapping("/{id}")
    public BookingMySQL getVehicleById(@PathVariable int id) {
        return bookingService.getVehicleById(id);
    }

    // Get all vehicles
    @GetMapping
    public List<BookingMySQL> getAllVehicles() {
        return bookingService.getAllVehicles();
    }

    // Delete vehicle by ID
    @DeleteMapping("/{id}")
    public void deleteVehicleById(@PathVariable int id) {
        bookingService.deleteVehicleById(id);
    }
}
