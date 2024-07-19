package com.example.firstJobApp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy= "company" )
	private List<Job> job;
	
	@OneToMany(mappedBy= "company" )
	private List<Review> reviews;

	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public Company(List<Job> job) {
		super();
		this.job = job;
	}
	public Company(Long id, String name, String description, List<Job> job) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.job = job;
	}
	public Company() {
	
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Job> getJob() {
		return job;
	}

	public void setJob(List<Job> job) {
		this.job = job;
	}
	

}
