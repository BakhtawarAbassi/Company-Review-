package com.example.firstJobApp.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.firstJobApp.models.Job;


import com.example.firstJobApp.models.Review;

public interface ReviewRepo extends JpaRepository<Review,Long>{

	List<Review> findByCompanyId(Long companyId);





}
