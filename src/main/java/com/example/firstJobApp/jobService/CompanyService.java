package com.example.firstJobApp.jobService;

import java.util.List;

import com.example.firstJobApp.models.Company;

public interface CompanyService {

	List<Company> getAllCompanies();
	void createCompany(Company company);
	boolean updateCompany(Company updateCompany, Long id);
	boolean deleteCompanyById(Long Id);
	Company getCompanyById(Long id);
}
