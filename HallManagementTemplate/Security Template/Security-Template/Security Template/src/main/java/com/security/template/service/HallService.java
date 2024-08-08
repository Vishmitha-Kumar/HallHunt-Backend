package com.security.template.service;

import com.security.template.enums.Role;
import com.security.template.model.Hall;
import com.security.template.model.HallDetails;
import com.security.template.model.User;
import com.security.template.repo.HallRepository;
import com.security.template.repo.UserRepo;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private UserRepo ur;
    public Hall addHalls(Hall halls) {

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String email=authentication.getName();

        String emails = authentication.getName();

        Optional<User> user = ur.findByEmail(emails);
        User foundUser = user.orElseThrow(() -> new UsernameNotFoundException("User not found"));


        if (foundUser.getRole() != Role.ADMIN) {
//            System.out.println("Only admin can add halls.");
            throw new RuntimeException("Only admin can add halls.");
        }

        halls.setUser(foundUser);

        return hallRepository.save(halls);
    }



    public Hall updateHall(Long id,Hall halls) {
        Optional<Hall> existingHall = hallRepository.findById(id);

        if (existingHall.isPresent()) {
            Hall updatedHall = existingHall.get();

            if (halls.getName() != null) updatedHall.setName(halls.getName());
            if (halls.getLocation() != null) updatedHall.setLocation(halls.getLocation());
            if (halls.getDescription() != null) updatedHall.setDescription(halls.getDescription());
            if (halls.getFunctype() != null) updatedHall.setFunctype(halls.getFunctype());
            if (halls.getHalltype() != null) updatedHall.setHalltype(halls.getHalltype());
            if (halls.getDetail() != null) updatedHall.setDetail(halls.getDetail());
            if (halls.getOrganiser() != null) updatedHall.setOrganiser(halls.getOrganiser());
            if (halls.getContact() != null) updatedHall.setContact(halls.getContact());

            if (halls.getHallDetails() != null) {
                HallDetails newDetails = halls.getHallDetails();
                HallDetails existingDetails = updatedHall.getHallDetails();

                if (newDetails.getVegprice() != 0) existingDetails.setVegprice(newDetails.getVegprice());
                if (newDetails.getNonvegprice() != 0) existingDetails.setNonvegprice(newDetails.getNonvegprice());
                if (newDetails.getReviews() != null) existingDetails.setReviews(newDetails.getReviews());
                if (newDetails.getGuest() != null) existingDetails.setGuest(newDetails.getGuest());
                if (newDetails.getPrice() != null) existingDetails.setPrice(newDetails.getPrice());
            }

            return hallRepository.save(updatedHall);
        } else {
            throw new RuntimeException("Hall not found");
        }
    }

    public String deleteHall(Long id) {
        hallRepository.deleteById(id);
        return "Deleted successfully";
    }

    public Optional<Hall> getHalls(Long id) {
       return hallRepository.findById(id);
    }

    public List<Hall> getAllHall() {
        return hallRepository.findAll();
        
    }

    public Hall getHallById(Long hallId) {
        return hallRepository.findById(hallId).orElseThrow(() -> new RuntimeException("Hall not found"));
    }
}
