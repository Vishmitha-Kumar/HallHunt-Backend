package com.security.template.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.security.template.dto.StatusDto;
import com.security.template.model.Booking;
import com.security.template.model.User;
import com.security.template.repo.UserRepo;
import com.security.template.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bs;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepo userRepository;

    @PostMapping("/bookHalls/{hallID}")
    public ResponseEntity<?> bookHalls(@RequestBody Booking books, @PathVariable Long hallID){

        try{
            objectMapper.registerModule(new JavaTimeModule());

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            String email = authentication.getName();

            Optional<User> user = userRepository.findByEmail(email);
            User foundUser = user.orElseThrow(() -> new UsernameNotFoundException("User not found"));

            Booking booked=bs.bookHalls(books, foundUser.getId(), hallID);
        return new ResponseEntity<>("Registered Successfully",HttpStatus.CREATED);
        }
        catch(RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAlls")
    public ResponseEntity<?> getAllBooking(){
        return new ResponseEntity<>(bs.getAllBooking(),HttpStatus.OK);
       }

    @GetMapping("/getBooking/{id}")
     public ResponseEntity<?> getBooking(@PathVariable Long id){
    return new ResponseEntity<>(bs.getBooking(id),HttpStatus.OK);
   }

   @PutMapping("/putBooking/{id}")
  public ResponseEntity<?> updateBooking(@PathVariable Long id,@RequestBody Booking books){
    try{
        Booking updatebooks=bs.updateBooking(id,books);
        return new ResponseEntity<>(updatebooks,HttpStatus.OK);
    }
    catch(RuntimeException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

  }
    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        String result = bs.deleteBooking(id);
        if (result.equals("Booking deleted successfully")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/update-status/{hallID}")
    public ResponseEntity<?> updateHallStatus(@PathVariable Long hallID, @RequestBody StatusDto hallStatus) {

        try{

            Boolean response = bs.updateHallStatus(hallID, hallStatus);

            if(response)
                return new ResponseEntity<>("Hall : " + hallID + " updated successfully to status - " + hallStatus.getBookingStatus(), HttpStatus.OK);
            else
                return new ResponseEntity<>("Hall not found", HttpStatus.NOT_FOUND);

        }catch (Exception e){


            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/get/requests")
    public ResponseEntity<?> fetchBookingRequests() {

        try{

            objectMapper.registerModule(new JavaTimeModule());

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            String email = authentication.getName();

            Optional<User> user = userRepository.findByEmail(email);
            User foundUser = user.orElseThrow(() -> new UsernameNotFoundException("User not found"));

            List<Booking> bookingRequestsForOwner = bs.getBookingRequestsForOwner(foundUser.getId());
            return new ResponseEntity<>(bookingRequestsForOwner, HttpStatus.OK);

        }catch (Exception e){


            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
