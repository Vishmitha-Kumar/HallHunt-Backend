package com.security.template.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String occasion;
    private String guest;
    private Long contact;
    private Long budget;
    private String food;
    @Temporal(TemporalType.DATE)
    private Date fromdate;
    @Temporal(TemporalType.DATE)
    private Date todate;

//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="user_id")
//     @JsonIgnore
    private User users;

//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="hall_id")
//     @JsonIgnore
    private Hall halls;

    
    public Booking() {
    }

    public Booking(Long id, String occasion, String guest, Long contact, Long budget, String food, Date fromdate,
            Date todate, User users, Hall halls) {
        this.id = id;
        this.occasion = occasion;
        this.guest = guest;
        this.contact = contact;
        this.budget = budget;
        this.food = food;
        this.fromdate = fromdate;
        this.todate = todate;
        this.users = users;
        this.halls = halls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Hall getHalls() {
        return halls;
    }

    public void setHalls(Hall halls) {
        this.halls = halls;
    }

   
}
