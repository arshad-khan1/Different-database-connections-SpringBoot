package com.pinnacle.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.pinnacle.bus.model.LocationPostgresql;

@Service
public class LocationServicePostgresql {

    @Qualifier("postgresqlJdbcTemplate")
    private final JdbcTemplate jdbcTemplate;
    
    public LocationServicePostgresql(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create a new location
    public LocationPostgresql createLocation(LocationPostgresql location) {
        String query = "INSERT INTO location (id, name) VALUES (?, ?)";
        jdbcTemplate.update(query, location.getId(), location.getName());
        return location;
    }

    // Get location by ID
    public LocationPostgresql getLocationById(int id) {
        String query = "SELECT * FROM location WHERE id = ?";
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
            LocationPostgresql location = new LocationPostgresql();
            location.setId(rs.getInt("id"));
            location.setName(rs.getString("name"));
            return location;
        }, id);
    }

    // Get all locations
    public List<LocationPostgresql> getAllLocations() {
        String query = "SELECT * FROM location";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            LocationPostgresql location = new LocationPostgresql();
            location.setId(rs.getInt("id"));
            location.setName(rs.getString("name"));
            return location;
        });
    }

    // Delete location by ID
    public void deleteLocationById(int id) {
        String query = "DELETE FROM location WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
