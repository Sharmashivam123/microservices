package com.explore.microservices.web.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.explore.microservices.domain.Tour;
import com.explore.microservices.domain.TourRating;
import com.explore.microservices.domain.TourRatingPk;
import com.explore.microservices.domain.dto.TourRatingDto;
import com.explore.microservices.repo.TourRatingRepo;
import com.explore.microservices.repo.TourRepo;

@RestController
public class TourRatingcontroller {

	private TourRepo tourRepo;
	private TourRatingRepo tourRatingRepo;
	
	@Autowired	
	public TourRatingcontroller(TourRepo tourRepo, TourRatingRepo tourRatingRepo) {
		super();
		this.tourRepo = tourRepo;
		this.tourRatingRepo = tourRatingRepo;
	}
	@PostMapping("/tours/{tourId}/ratings")
	@ResponseStatus(value = HttpStatus.CREATED)
	public TourRating saveRating(@PathVariable("tourId") int tourId, @RequestBody TourRatingDto tourRatingDto) {
		Tour tour = verifyTour(tourId);
		return tourRatingRepo.save(new TourRating(new TourRatingPk(tour, tourRatingDto.getCustomerId()), tourRatingDto.getScore(), tourRatingDto.getComment()));
	}
	
	private Tour verifyTour(int tourId) {
		return tourRepo.findById(tourId).orElseThrow(()->new NoSuchElementException("Tour does not Exist: "+tourId));
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400 (NoSuchElementException exception) {
		return exception.getMessage();
	}
}
