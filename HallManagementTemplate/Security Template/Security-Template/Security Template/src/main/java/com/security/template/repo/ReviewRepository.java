package com.security.template.repo;

import com.security.template.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>{

    
    
}
