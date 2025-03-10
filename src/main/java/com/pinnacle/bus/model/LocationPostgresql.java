package com.pinnacle.bus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LocationPostgresql {
    @Id
    private int id; // Primary key

    private String name; // Location name

    // Default constructor
    public LocationPostgresql() {}

    // Parameterized constructor
    public LocationPostgresql(int id, String name) {
        this.id = id;
        this.name = name;
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
}
