package com.security.template.service;

import com.security.template.model.Booking;
import com.security.template.model.Hall;
import com.security.template.model.User;
import com.security.template.repo.BookingRepository;
import com.security.template.repo.HallRepository;
import com.security.template.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private UserRepository userRepository;

    public Booking bookHalls(Booking booking) {
        Optional<User> user = userRepository.findById(booking.getUsers().getId());
        Optional<Hall> hall = hallRepository.findById(booking.getHalls().getId());

        if (user.isPresent() && hall.isPresent()) {
            booking.setUsers(user.get());
            booking.setHalls(hall.get());
            return bookingRepository.save(booking);
        } else {
            throw new RuntimeException("User or Hall not found");
        }
    }
    
    public List<Booking> getAllBooking() {
      return bookingRepository.findAll();
    }
    
    public Optional<Booking> getBooking(Long id) {
        return bookingRepository.findById(id);
        
    }
    public Booking updateBooking(Long id,Booking booking) {
        Optional<Booking> existingBooking = bookingRepository.findById(id);
        
        if (existingBooking.isPresent()) {
            Booking updatedBooking = existingBooking.get();
            updatedBooking.setOccasion(booking.getOccasion());
            updatedBooking.setGuest(booking.getGuest());
            updatedBooking.setContact(booking.getContact());
            updatedBooking.setBudget(booking.getBudget());
            updatedBooking.setFood(booking.getFood());
            updatedBooking.setFromdate(booking.getFromdate());
            updatedBooking.setTodate(booking.getTodate());
            
           
            Optional<User> user = userRepository.findById(booking.getUsers().getId());
            Optional<Hall> hall = hallRepository.findById(booking.getHalls().getId());

            if (user.isPresent() && hall.isPresent()) {
                updatedBooking.setUsers(user.get());
                updatedBooking.setHalls(hall.get());
                return bookingRepository.save(updatedBooking);
            } else {
                throw new RuntimeException("User or Hall not found");
            }
        } else {
            throw new RuntimeException("Booking not found");
        }
    }
}

