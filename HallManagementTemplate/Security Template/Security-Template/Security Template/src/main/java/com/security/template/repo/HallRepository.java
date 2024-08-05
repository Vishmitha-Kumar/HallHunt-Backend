package com.security.template.repo;

import java.util.List;

import com.security.template.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {

    // String deleteAllById(Long id);
    

    
}
