package com.pinnacle.bus.repository;

import com.pinnacle.bus.model.Booking;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface BookingRepository extends MongoRepository<Booking, String> {

}
