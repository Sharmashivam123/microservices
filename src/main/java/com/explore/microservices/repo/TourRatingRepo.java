package com.explore.microservices.repo;

import org.springframework.data.repository.CrudRepository;

import com.explore.microservices.domain.TourRating;
import com.explore.microservices.domain.TourRatingPk;

public interface TourRatingRepo extends CrudRepository<TourRating, TourRatingPk>{

	
}
