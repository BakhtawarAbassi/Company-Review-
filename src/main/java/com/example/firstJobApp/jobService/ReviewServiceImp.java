package com.example.firstJobApp.jobService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstJobApp.Repository.ReviewRepo;
import com.example.firstJobApp.models.Company;
import com.example.firstJobApp.models.Review;

@Service
public class ReviewServiceImp implements ReviewService{

	@Autowired
	private ReviewRepo reviewRepo;
	
	@Autowired
	private CompanyService companyService;
	@Override
	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviews= reviewRepo.findByCompanyId(companyId);
		return reviews;
	}
	@Override
	public boolean addReview(Long companyId, Review review) {
		// TODO Auto-generated method stub
		
		Company company= companyService.getCompanyById(companyId);
		if(company!=null) {
			review.setCompany(company);
			reviewRepo.save(review);
			return true;
		}
		else 
			return false;
	}
	@Override
	public Review getReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		List<Review> reviews=reviewRepo.findByCompanyId(companyId);
		
		return reviews.stream()
				.filter(review ->review.getId().equals(reviewId))
				.findFirst()
				.orElse(null);
		
	}
	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
		// TODO Auto-generated method stub
		if(companyService.getCompanyById(companyId)!=null) {
			updatedReview.setCompany(companyService.getCompanyById(companyId));
			updatedReview.setId(reviewId); 
			reviewRepo.save(updatedReview);
			return true;
		}

		return false;
	}
	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		if(companyService.getCompanyById(companyId)!=null &&
				reviewRepo.existsById(reviewId)) {
			Review review =	reviewRepo.findById(reviewId).orElse(null);
		Company company=review.getCompany();
		company.getReviews().remove(review);
		review.setCompany(null);
		companyService.updateCompany(company, companyId);
		  reviewRepo.deleteById(reviewId);
		  return true;
		}
		
			return false;		
		}
	
	}




