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

import com.pinnacle.bus.model.LocationPostgresql;
import com.pinnacle.bus.service.LocationServicePostgresql;

@RestController
@RequestMapping("/api/postgresql/locations")
public class LocationControllerPostgresql {

    @Autowired
    private LocationServicePostgresql locationService;

    // Create a new location
    @PostMapping
    public LocationPostgresql createLocation(@RequestBody LocationPostgresql location) {
        return locationService.createLocation(location);
    }

    // Get location by ID
    @GetMapping("/{id}")
    public LocationPostgresql getLocationById(@PathVariable int id) {
        return locationService.getLocationById(id);
    }

    // Get all locations
    @GetMapping
    public List<LocationPostgresql> getAllLocations() {
        return locationService.getAllLocations();
    }

    // Delete location by ID
    @DeleteMapping("/{id}")
    public void deleteLocationById(@PathVariable int id) {
        locationService.deleteLocationById(id);
    }
}
