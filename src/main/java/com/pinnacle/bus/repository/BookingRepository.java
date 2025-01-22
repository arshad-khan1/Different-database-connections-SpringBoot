package com.pinnacle.bus.repository;

import com.pinnacle.bus.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
