package com.example.firstJobApp.jobService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstJobApp.Repository.JobRepo;
import com.example.firstJobApp.models.Job;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	private JobRepo jobRepo;
	public List<Job> jobs=new ArrayList<>();

	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobRepo.findAll();
	}

	@Override
	public void createJob(Job job) {
		jobRepo.save(job);
	}

	@Override
	public Job findById(Long id) {
		// TODO Auto-generated method stub
	
			return jobRepo.findById(id).orElse(null);

	}

	@Override
	public boolean deleteJob(Long id) {
//		Iterator<Job> iterator=jobs.iterator();
//		while(iterator.hasNext()) {
//			Job job=iterator.next();
//			if(job.getId().equals(id)) {
//				iterator.remove();
//				return true;
//			}
//				
//		}
//	
//			return false;
		try {
		jobRepo.deleteById(id);
		return true;
	}
		catch(Exception e) {
			return false;
		}
		}

	@Override
	public boolean updateJob(Long id, Job updateJob) {
		// TODO Auto-generated method stub

		Optional<Job> jobOptional=jobRepo.findById(id);
		if(jobOptional.isPresent()) {
			Job job=jobOptional.get();
			job.setDescription(updateJob.getDescription());
			job.setLocation(updateJob.getLocation());
			job.setMaxSalary(updateJob.getMaxSalary());
			job.setMinSalary(updateJob.getMinSalary());
			job.setTitle(updateJob.getTitle());
			jobRepo.save(job);
			return true;
		}
		return false;
}
}