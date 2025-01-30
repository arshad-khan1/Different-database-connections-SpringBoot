package com.pinnacle.bus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class VehicleMySQL {
    @Id
    private int id; // Primary key (MySQL uses int or bigint for IDs)

    private String name; // Vehicle name
    private String number; // Vehicle number (license plate or unique identifier)
    private String type; // Vehicle type (e.g., Bus, Car, etc.)
    private int availableSeats; // Number of available seats

    // Default constructor
    public VehicleMySQL() {}

    // Parameterized constructor
    public VehicleMySQL(int id, String name, String number, String type, int availableSeats) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.type = type;
        this.availableSeats = availableSeats;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}