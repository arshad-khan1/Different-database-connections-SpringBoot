package com.pinnacle.bus.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class BookingMysql {
    @Id
    private int id; // Primary key (MySQL uses int or bigint for IDs)

    private String route;
    private String userid;
    private String fromlocation;
    private String tolocation;
    private LocalDateTime date;
    private int seatnumber;
    private int price;
    private String status;
    private LocalDateTime bookedat = LocalDateTime.now();

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFromlocation() {
        return fromlocation;
    }

    public void setFromlocation(String fromlocation) {
        this.fromlocation = fromlocation;
    }

    public String getTolocation() {
        return tolocation;
    }

    public void setTolocation(String tolocation) {
        this.tolocation = tolocation;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(int seatnumber) {
        this.seatnumber = seatnumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getBookedat() {
        return bookedat;
    }

    public void setBookedat(LocalDateTime bookedat) {
        this.bookedat = bookedat;
    }
}
