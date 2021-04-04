package com.explore.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.explore.microservices.domain.Difficulty;
import com.explore.microservices.domain.Region;
import com.explore.microservices.domain.Tour;
import com.explore.microservices.domain.TourPackage;
import com.explore.microservices.repo.TourPackageRepo;
import com.explore.microservices.repo.TourRepo;

@Service
public class TourService {

	private TourRepo tourRepo;
	private TourPackageRepo tourPackageRepo;

	@Autowired
	public TourService(TourRepo tourRepo, TourPackageRepo tourPackageRepo) {
		this.tourRepo = tourRepo;
		this.tourPackageRepo = tourPackageRepo;
	}

	public Tour createTour(String title, String description, String blurb, Integer price, String duration,
			String bullets, String keywords, String tourPackageName, Difficulty difficulty, Region region) {
		TourPackage tourPackage = tourPackageRepo.findByName(tourPackageName)
				.orElseThrow(() -> new RuntimeException("Tour package does not exist: " + tourPackageName));

		return tourRepo.save(new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage,
				difficulty, region));
	}
	
	public long total() {
		return tourRepo.count();
	}
}
