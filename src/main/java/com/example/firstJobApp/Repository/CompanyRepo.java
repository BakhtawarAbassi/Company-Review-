package com.example.firstJobApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstJobApp.models.Company;

public interface CompanyRepo extends JpaRepository<Company,Long> {

}
