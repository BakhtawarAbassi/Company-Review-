package com.example.firstJobApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.firstJobApp.jobService.ReviewService;
import com.example.firstJobApp.models.Company;
import com.example.firstJobApp.models.Job;
import com.example.firstJobApp.models.Review;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	
	@PostMapping("/reviews")
	public ResponseEntity<String> addReview(@PathVariable Long companyId ,@RequestBody Review review) {
		
	boolean addReview=reviewService.addReview(companyId, review);
	if(addReview)
	    return new ResponseEntity<>("Review Added Successfully",HttpStatus.OK);
	return new ResponseEntity<>("Review not Addedd",HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId){
		return new ResponseEntity<>(reviewService.getAllReviews(companyId),HttpStatus.OK);
	}
	
	@GetMapping("/reviews/{reviewId}")
	public  ResponseEntity<Review> getReview(@PathVariable Long companyId,
												@PathVariable Long reviewId){
		return new ResponseEntity<>(reviewService.getReview(companyId, reviewId),HttpStatus.OK);
	}
	

	@PutMapping("/review/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long companyId,
												@PathVariable Long reviewId,
												@RequestBody Review review){
		boolean isUpdated=reviewService.updateReview(companyId, reviewId, review);
		if(isUpdated)
		return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
		else
			return new ResponseEntity<>("Not Updated",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
												@PathVariable Long reviewId){
		boolean isDeleted=reviewService.deleteReview(companyId, reviewId);
		if(isDeleted)
		return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
		else
			return new ResponseEntity<>("Not Deleted",HttpStatus.NOT_FOUND);
	}

}

