package com.pinnacle.bus.service;

import com.pinnacle.bus.model.BookingMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceMongo {

    @Autowired
    private MongoTemplate mongoTemplate;

    public BookingMongo createBooking(BookingMongo booking) {
        return mongoTemplate.save(booking);
    }

    public BookingMongo getBookingById(String id) {
        return mongoTemplate.findById(id, BookingMongo.class);
    }

    public List<BookingMongo> getAllBookings() {
        return mongoTemplate.findAll(BookingMongo.class);
    }

    public void deleteBookingById(String id) {
        mongoTemplate.remove(mongoTemplate.findById(id, BookingMongo.class));
    }
}
