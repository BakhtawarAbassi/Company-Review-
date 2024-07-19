package com.example.firstJobApp.jobService;

import java.util.List;

import com.example.firstJobApp.models.Job;

public interface JobService {
	List<Job> findAll();
	void createJob(Job job);
	Job findById(Long id);
	boolean deleteJob(Long id);
	boolean updateJob(Long id, Job updateJob);

}
