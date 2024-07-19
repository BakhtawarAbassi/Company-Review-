package com.example.firstJobApp.controllers;

import java.util.ArrayList;
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

import com.example.firstJobApp.jobService.JobService;
import com.example.firstJobApp.models.Company;
import com.example.firstJobApp.models.Job;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private JobService jobService;
	public List<Job> jobs=new ArrayList<>();
	
	@GetMapping
	public ResponseEntity<List<Job>> findAll(){
		return ResponseEntity.ok(jobService.findAll());
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Job> findById(@PathVariable Long id){
		Job job=jobService.findById(id);
		if(job!=null)
		return new ResponseEntity<>(job,HttpStatus.OK);
		
		return new ResponseEntity<>(job,HttpStatus.NOT_FOUND);
		
	}
	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job){
		jobService.createJob(job);
		Company c=job.getCompany();
		return new ResponseEntity<>("Job Added Successfull",HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable Long id){
		boolean deleted=jobService.deleteJob(id);
		if(deleted)
		return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
	
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> updateJob(@PathVariable Long id,
												@RequestBody Job updateJob){
		boolean updated=jobService.updateJob(id,updateJob);
		if(updated) {
			return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
