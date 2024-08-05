package com.security.template.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Embeddable
public class HallDetails {


    private int vegprice;
    private int nonvegprice;
    private String reviews;
    private String guest;
    private String price;


    public HallDetails() {
    }
    public HallDetails( int vegprice, int nonvegprice, String reviews, String guest, String price) {
     
        this.vegprice = vegprice;
        this.nonvegprice = nonvegprice;
        this.reviews = reviews;
        this.guest = guest;
        this.price = price;
    }
   
    public int getVegprice() {
        return vegprice;
    }
    public void setVegprice(int vegprice) {
        this.vegprice = vegprice;
    }
    public int getNonvegprice() {
        return nonvegprice;
    }
    public void setNonvegprice(int nonvegprice) {
        this.nonvegprice = nonvegprice;
    }
    public String getReviews() {
        return reviews;
    }
    public void setReviews(String reviews) {
        this.reviews = reviews;
    }
    public String getGuest() {
        return guest;
    }
    public void setGuest(String guest) {
        this.guest = guest;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
   
    
    
}
