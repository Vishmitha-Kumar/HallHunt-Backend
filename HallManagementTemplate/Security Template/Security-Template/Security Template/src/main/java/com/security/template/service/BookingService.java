package com.security.template.service;

import com.security.template.dto.StatusDto;
import com.security.template.model.Booking;
import com.security.template.model.Hall;
import com.security.template.model.User;
import com.security.template.repo.BookingRepository;
import com.security.template.repo.HallRepository;
import com.security.template.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService us;

    @Autowired
    private  HallService hs;

    public Booking bookHalls(Booking booking,Long userID,Long hallID) {

        
        Optional<User> user = userRepository.findById(userID);
        Optional<Hall> hall = hallRepository.findById(hallID);

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

    public String deleteBooking(Long id) {
        Optional<Booking> books = bookingRepository.findById(id);

        if (books.isPresent()) {
            bookingRepository.deleteById(id);
            return "Booking deleted successfully";
        } else {
            return "No Booking found";
        }
    }

    public Boolean updateHallStatus(Long hallID, StatusDto hallStatus) {

        Optional<Booking> hallObj = bookingRepository.findById(hallID);

        if(hallObj.isEmpty())
            return false;

        Booking hallObj1 = hallObj.get();
        hallObj1.setBookingStatus(hallStatus.getBookingStatus());
        bookingRepository.save(hallObj1);
        return true;

    }
    public List<Booking> getBookedDetails(String status) {
        return bookingRepository.findAllByBookingStatus(status);
    }


    public List<Booking> getBookingRequestsForOwner(Long userID) {

        List<Long> ownedHalls = hs.getHallDetailsByUser(userID)
                .stream().map(Hall::getId).toList();

        System.out.println(userID);

        List<Booking> bookings= new ArrayList<>();
        for (Long id : ownedHalls) {
            List<Booking> hallObj = bookingRepository.findByHalls_Id(id);
            bookings.addAll(hallObj);
        }
        return bookings;
    }

    public Booking updateBookingStatus(Long id, String status) {
        Optional<Booking> existingBooking = bookingRepository.findById(id);

        if (existingBooking.isPresent()) {
            Booking booking = existingBooking.get();
            booking.setBookingStatus(status);
            return bookingRepository.save(booking);
        } else {
            throw new RuntimeException("Booking not found");
        }
    }

    public List<Booking> getAllBooking() {
        return bookingRepository.findAll().stream().peek(booking -> {
            booking.getHalls().getName(); // Ensure hall name is fetched
        }).collect(Collectors.toList());
    }

}

