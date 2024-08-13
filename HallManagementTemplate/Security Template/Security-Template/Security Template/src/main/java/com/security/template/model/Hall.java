package com.security.template.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
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

//    @OneToMany(mappedBy = "halls")
//    @JsonIgnore
//    @JsonBackReference
//    private List<Booking> bookings;

    @Embedded
    private HallDetails hallDetails;

//    @OneToMany(mappedBy = "halls")
//    @JsonIgnore
//    private List<HallImages> hallImages;



//    @JoinColumn(name = "user_id")
//    @JsonBackReference
    @ManyToOne
    private User user;

    public Hall() {
    }

    public Hall(Long id, String hallname, String location, String description, String type, String halltype, String organiser, String contact, HallDetails hallDetails, User user) {
        this.id = id;
        this.hallname = hallname;
        this.location = location;
        this.description = description;
        this.type = type;
        this.halltype = halltype;
        this.organiser = organiser;
        this.contact = contact;
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
        this.hallname = hallname;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
