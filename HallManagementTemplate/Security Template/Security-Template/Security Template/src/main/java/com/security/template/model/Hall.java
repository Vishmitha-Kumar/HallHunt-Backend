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
    private String name;
    private String location;
    private String description;
    private String functype;
    private String halltype;
    private String detail;
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

    public Hall(Long id, String name, String location, String description, String functype, String halltype, String detail, String organiser, String contact, List<Booking> bookings, HallDetails hallDetails, User user) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.functype = functype;
        this.halltype = halltype;
        this.detail = detail;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFunctype() {
        return functype;
    }

    public void setFunctype(String functype) {
        this.functype = functype;
    }

    public String getHalltype() {
        return halltype;
    }

    public void setHalltype(String halltype) {
        this.halltype = halltype;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
