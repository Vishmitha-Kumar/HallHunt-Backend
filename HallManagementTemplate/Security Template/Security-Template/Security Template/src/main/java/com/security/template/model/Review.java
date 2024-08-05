package com.security.template.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String userreview;
    public Review() {
    }
    public Review(Long id, String name, String userreview) {
        this.id = id;
        this.name = name;
        this.userreview = userreview;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserreview() {
        return userreview;
    }
    public void setUserreview(String userreview) {
        this.userreview = userreview;
    }
    
    
    
}
