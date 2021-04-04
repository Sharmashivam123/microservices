package com.explore.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.explore.microservices.domain.TourPackage;
import com.explore.microservices.repo.TourPackageRepo;

@Service
public class TourPackageService {

	TourPackageRepo tourPackageRepo;
	
	@Autowired
	public TourPackageService(TourPackageRepo tourPackageRepo) {
		this.tourPackageRepo = tourPackageRepo;
	}
	
	public TourPackage createTourPackage(String code, String name) {
		return tourPackageRepo.findById(code).orElse(tourPackageRepo.save(new TourPackage(code, name)));
	}
	
	public Iterable<TourPackage> lookUp() {
		return tourPackageRepo.findAll();
	}
	
	public long countTotalPackages() {
		return tourPackageRepo.count();
	}
}
