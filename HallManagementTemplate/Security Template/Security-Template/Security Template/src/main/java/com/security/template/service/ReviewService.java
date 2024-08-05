package com.security.template.service;

import java.util.List;
import java.util.Optional;

import com.security.template.model.Review;
import com.security.template.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ReviewService {

    @Autowired
    private ReviewRepository rr;

    public Review postReview(Review reviews) {
        return rr.save(reviews);
    }

    public Review updateReview(Long id, Review review) {
        Optional<Review> optionalReview = rr.findById(id);

        if (optionalReview.isPresent()) {
            Review existingReview = optionalReview.get();
            existingReview.setName(review.getName());
            existingReview.setUserreview(review.getUserreview());
            return rr.save(existingReview);
        } else {
            // You can throw an exception or handle it as per your requirement
            throw new RuntimeException("Review not found with id " + id);
        }
    }

    public String deleteReview(Long id) {
        rr.deleteById(id);
        return "Deleted successfully";
    }
    

     public Optional<Review> getReviews(Long id) {
       return rr.findById(id);
    }

    public List<Review> getAllReview() {
        return rr.findAll();
        
    }
}
