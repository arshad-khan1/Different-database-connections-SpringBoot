package com.pinnacle.bus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String route;
    private String userid;
    private String fromlocation;
    private String tolocation;
    private LocalDateTime date;
    private int seatnumber;
    private int price;
    private String status;
    private LocalDateTime bookedat = LocalDateTime.now();

}


