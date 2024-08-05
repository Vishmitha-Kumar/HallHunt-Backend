package com.security.template.controller;

import com.security.template.model.Booking;
import com.security.template.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bs;

    @PostMapping("/bookHalls")
    public ResponseEntity<?> bookHalls(@RequestBody Booking books){

        try{
            Booking booked=bs.bookHalls(books);
        return new ResponseEntity<>(booked,HttpStatus.CREATED);
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
    
    
  
}
