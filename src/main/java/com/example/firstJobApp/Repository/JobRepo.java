package com.example.firstJobApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstJobApp.models.Job;

public interface JobRepo extends JpaRepository<Job,Long>{

}
