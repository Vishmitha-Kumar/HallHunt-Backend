package com.security.template.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Embeddable
public class HallDetails {


    private int vegPrice;
    private int nonveg;
    private String reviews;
    private String guestRange;
    private String priceRange;


    public HallDetails() {
    }


    public HallDetails(int vegPrice, int nonveg, String reviews, String guestRange, String priceRange) {
        this.vegPrice = vegPrice;
        this.nonveg = nonveg;
        this.reviews = reviews;
        this.guestRange = guestRange;
        this.priceRange = priceRange;
    }

    public int getVegPrice() {
        return vegPrice;
    }

    public void setVegPrice(int vegPrice) {
        this.vegPrice = vegPrice;
    }

    public int getNonveg() {
        return nonveg;
    }

    public void setNonveg(int nonveg) {
        this.nonveg = nonveg;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getGuestRange() {
        return guestRange;
    }

    public void setGuestRange(String guestRange) {
        this.guestRange = guestRange;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}
