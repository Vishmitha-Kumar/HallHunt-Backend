package com.security.template.controller;

import com.security.template.model.Review;
import com.security.template.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService rs;

    @PostMapping("/postReview")
    public Review postReview(@RequestBody Review review ){
        return rs.postReview(review);
    }


    @PutMapping("updateReview/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
        return rs.updateReview(id,review);
       }
 
    
    @DeleteMapping("deleteReview/{id}")
    public String deleteReview(@PathVariable Long id){
        return rs.deleteReview(id);
       }
      @GetMapping("/getReview/{id}")
   public ResponseEntity<?> getReviews(@PathVariable Long id){
    return new ResponseEntity<>(rs.getReviews(id),HttpStatus.OK);
   }
    
   @GetMapping("/getReviews")
   public ResponseEntity<?> getAllReview(){
    return new ResponseEntity<>(rs.getAllReview(),HttpStatus.OK);
   }
}
