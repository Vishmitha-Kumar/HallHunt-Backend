package com.security.template.controller;

import java.util.List;
import java.util.Map;

import com.security.template.model.User;
import com.security.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")

public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User postUser(@RequestBody User user) {
     
        return service.postUser(user);
    }
    
    @GetMapping("/get")
    public List<User> getUser() {
        return service.getUser();
        
    }
    @PostMapping("/login")
    public String loginUser(@RequestBody Map<String,String> login) {
     
        return service.loginUser(login);
    }
       
}
