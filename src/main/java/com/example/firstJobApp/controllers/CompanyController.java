package com.example.firstJobApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstJobApp.jobService.CompanyService;
import com.example.firstJobApp.models.Company;
import com.example.firstJobApp.models.Job;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies(){
			
				return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
		Company  company=companyService.getCompanyById(id);
		if(company!=null)
		return new ResponseEntity<>(company,HttpStatus.OK);
		
		return new ResponseEntity<>(company,HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody Company company){
		
		companyService.createCompany(company);
		return new ResponseEntity<>("Company Created Successfully",HttpStatus.OK);
		
	}
 
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company updateCompany) {
		
		boolean updated=companyService.updateCompany(updateCompany,id);
		if(updated)
			return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id){
		boolean isDeleted=companyService.deleteCompanyById(id);
		if(isDeleted) 
			return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
		
		return new ResponseEntity<>("Data Not Found",HttpStatus.NOT_FOUND);
		
		
}
}