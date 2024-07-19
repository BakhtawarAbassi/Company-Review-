package com.example.firstJobApp.jobService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstJobApp.Repository.CompanyRepo;
import com.example.firstJobApp.models.Company;
import com.example.firstJobApp.models.Job;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyRepo companyRepo;
	
	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepo.findAll();
	}

	
	@Override
	public boolean updateCompany(Company company,Long id) {
		// TODO Auto-generated method stub
		
		Optional<Company> companyOptional=companyRepo.findById(id);
		if(companyOptional.isPresent()) {
			Company companyToUpdate=companyOptional.get();
			companyToUpdate.setDescription(companyToUpdate.getDescription());
			companyToUpdate.setName(companyToUpdate.getName());
			companyToUpdate.setJob(company.getJob());
			companyRepo.save(companyToUpdate);
			return true;
		}
		return false;
		
		
	}


	@Override
	public void createCompany(Company company) {
		// TODO Auto-generated method stub
		companyRepo.save(company);
	}

	@Override
	public boolean deleteCompanyById(Long Id) {
		// TODO Auto-generated method stub
		if(companyRepo.existsById(Id)) {
			companyRepo.deleteById(Id);
			return true;
		}
		return false;
	
	}


	@Override
	public Company getCompanyById(Long id) {
		return companyRepo.findById(id).orElse(null);
		
	}

	
	}

	



