package com.pinnacle.bus.service;

import com.pinnacle.bus.model.BookingMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceMysql {

    @Autowired(required=true)
    private JdbcTemplate jdbcTemplate;

    public BookingMysql createBooking(BookingMysql booking) {
        String query = "INSERT INTO booking (route, userid, fromlocation, tolocation, date, seatnumber, price, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, booking.getRoute(), booking.getUserid(), booking.getFromlocation(), booking.getTolocation(), booking.getDate(),
                booking.getSeatnumber(), booking.getPrice(), booking.getStatus());
        return booking;
    }

    

    public BookingMysql getBookingById(int id) {
        String query = "SELECT * FROM booking WHERE id = ?";
        
        return jdbcTemplate.queryForObject(query, 
            (rs, rowNum) -> {
                BookingMysql booking = new BookingMysql();
                booking.setId(rs.getInt("id"));
                booking.setRoute(rs.getString("route"));
                booking.setUserid(rs.getString("userid"));
                booking.setFromlocation(rs.getString("fromlocation"));
                booking.setTolocation(rs.getString("tolocation"));
                booking.setDate(rs.getTimestamp("date").toLocalDateTime());
                booking.setSeatnumber(rs.getInt("seatnumber"));
                booking.setPrice(rs.getInt("price"));
                booking.setStatus(rs.getString("status"));
                booking.setBookedat(rs.getTimestamp("bookedat").toLocalDateTime());
                return booking;
            }, 
            id // Replaces the Object[] array
        );
    }

//     public BookingMysql getBookingById(int id) {
//     String query = "SELECT * FROM booking WHERE id = ?";
    
//     return jdbcTemplate.queryForObject(query, 
//         new BeanPropertyRowMapper<>(BookingMysql.class), 
//         id // Replaces the Object[] array
//     );
// }
    

    public List<BookingMysql> getAllBookings() {
        String query = "SELECT * FROM booking";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            BookingMysql booking = new BookingMysql();
            booking.setId(rs.getInt("id"));
            booking.setRoute(rs.getString("route"));
            booking.setUserid(rs.getString("userid"));
            booking.setFromlocation(rs.getString("fromlocation"));
            booking.setTolocation(rs.getString("tolocation"));
            booking.setDate(rs.getTimestamp("date").toLocalDateTime());
            booking.setSeatnumber(rs.getInt("seatnumber"));
            booking.setPrice(rs.getInt("price"));
            booking.setStatus(rs.getString("status"));
            return booking;
        });
    }

    public void deleteBookingById(int id) {
        String query = "DELETE FROM booking WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
