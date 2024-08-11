package com.security.template.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity

public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hallname;
    private String location;
    private String description;
    private String type;
    private String halltype;

    private String organiser;
    private String contact;

    @OneToMany(mappedBy = "halls")
    @JsonIgnore
//    @JsonBackReference
    private List<Booking> bookings;

    @Embedded
    private HallDetails hallDetails;

//    @OneToMany(mappedBy = "halls")
//    @JsonIgnore
//    private List<HallImages> hallImages;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Hall() {}

    public Hall(Long id, String hallname, String location, String description, String type, String halltype, String organiser, String contact, List<Booking> bookings, HallDetails hallDetails, User user) {
        this.id = id;
        this.hallname = hallname;
        this.location = location;
        this.description = description;
        this.type = type;
        this.halltype = halltype;
        this.organiser = organiser;
        this.contact = contact;
        this.bookings = bookings;
        this.hallDetails = hallDetails;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHallname() {
        return hallname;
    }

    public void setHallname(String hallname) {
        this.hallname =hallname;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public String getHalltype() {
        return halltype;
    }

    public void setHalltype(String halltype) {
        this.halltype = halltype;
    }



    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public HallDetails getHallDetails() {
        return hallDetails;
    }

    public void setHallDetails(HallDetails hallDetails) {
        this.hallDetails = hallDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
