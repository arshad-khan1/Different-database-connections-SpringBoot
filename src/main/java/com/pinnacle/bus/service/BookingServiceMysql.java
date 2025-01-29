package com.pinnacle.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.pinnacle.bus.model.BookingMySQL;

@Service
public class BookingServiceMysql {
    
    @Qualifier("mysqlJdbcTemplate")
    private final JdbcTemplate jdbcTemplate;

    public BookingServiceMysql(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create a new vehicle
    public BookingMySQL createVehicle(BookingMySQL vehicle) {
        String query = "INSERT INTO vehicle (id, name, number, type, availableSeats) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, vehicle.getId(), vehicle.getName(), vehicle.getNumber(),
                vehicle.getType(), vehicle.getAvailableSeats());
        return vehicle;
    }

    // Get vehicle by ID
    public BookingMySQL getVehicleById(int id) {
        String query = "SELECT * FROM vehicle WHERE id = ?";
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
            BookingMySQL vehicle = new BookingMySQL();
            vehicle.setId(rs.getInt("id"));
            vehicle.setName(rs.getString("name"));
            vehicle.setNumber(rs.getString("number"));
            vehicle.setType(rs.getString("type"));
            vehicle.setAvailableSeats(rs.getInt("availableSeats"));
            return vehicle;
        }, id);
    }

    // Get all vehicles
    public List<BookingMySQL> getAllVehicles() {
        String query = "SELECT * FROM vehicle";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            BookingMySQL vehicle = new BookingMySQL();
            vehicle.setId(rs.getInt("id"));
            vehicle.setName(rs.getString("name"));
            vehicle.setNumber(rs.getString("number"));
            vehicle.setType(rs.getString("type"));
            vehicle.setAvailableSeats(rs.getInt("availableSeats"));
            return vehicle;
        });
    }

    // Delete vehicle by ID
    public void deleteVehicleById(int id) {
        String query = "DELETE FROM vehicle WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
