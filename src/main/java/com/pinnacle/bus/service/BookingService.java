package com.pinnacle.bus.service;

import com.pinnacle.bus.model.Booking;
import com.pinnacle.bus.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings(){
            return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
    public Booking addBooking(Booking booking){
        return bookingRepository.save(booking);
    }
    

    public void updateBooking(Long id, Booking updatedBooking){
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking with id " + id + " not found"));

        // Update fields
        existingBooking.setRoute(updatedBooking.getRoute());
        existingBooking.setUserid(updatedBooking.getUserid());
        existingBooking.setFromlocation(updatedBooking.getFromlocation());
        existingBooking.setTolocation(updatedBooking.getTolocation());
        existingBooking.setDate(updatedBooking.getDate());
        existingBooking.setSeatnumber(updatedBooking.getSeatnumber());
        existingBooking.setPrice(updatedBooking.getPrice());
        existingBooking.setStatus(updatedBooking.getStatus());

        // Save the updated booking
        bookingRepository.save(existingBooking);
    }
}