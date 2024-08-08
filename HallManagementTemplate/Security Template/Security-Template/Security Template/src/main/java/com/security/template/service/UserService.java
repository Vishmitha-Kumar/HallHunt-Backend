package com.security.template.service;

import java.util.List;
import java.util.Map;

import com.security.template.model.User;
import com.security.template.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository ur;

    public User postUser(User user) {
        
        return ur.save(user);
    }

    public List<User> getUser() {
               return ur.findAll();
    }

    public String loginUser(Map<String, String> login) 
    {
   
        String email=login.get("email");
        String password=login.get("password");
        User result=ur.findByEmail(email);
        if(result==null){
            return "Invalid user";
        }
        else{
            if(result.getPassword().equals(password)){
                return "Login successful";
            }
            else{
                return "Login failed";
            }
        }

    }

    public User fetchById(Long id) {

        return ur.getById(id);
    }
}
