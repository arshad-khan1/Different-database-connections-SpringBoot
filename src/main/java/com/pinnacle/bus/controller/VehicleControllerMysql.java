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

import com.pinnacle.bus.model.VehicleMySQL;
import com.pinnacle.bus.service.VehicleServiceMysql;

@RestController
@RequestMapping("/api/mysql/vehicles")
public class VehicleControllerMysql {

    @Autowired
    private VehicleServiceMysql vehicleService;

    // Create a new vehicle
    @PostMapping
    public VehicleMySQL createVehicle(@RequestBody VehicleMySQL vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    // Get vehicle by ID
    @GetMapping("/{id}")
    public VehicleMySQL getVehicleById(@PathVariable int id) {
        return vehicleService.getVehicleById(id);
    }

    // Get all vehicles
    @GetMapping
    public List<VehicleMySQL> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // Delete vehicle by ID
    @DeleteMapping("/{id}")
    public void deleteVehicleById(@PathVariable int id) {
        vehicleService.deleteVehicleById(id);
    }
}
