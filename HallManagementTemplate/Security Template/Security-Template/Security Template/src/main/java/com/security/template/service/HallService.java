package com.security.template.service;

import com.security.template.model.Hall;
import com.security.template.model.HallDetails;
import com.security.template.repo.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    public Hall addHalls(Hall halls) {
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
