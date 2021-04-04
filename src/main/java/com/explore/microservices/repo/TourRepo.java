package com.explore.microservices.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.explore.microservices.domain.Tour;
	
@RepositoryRestResource
public interface TourRepo extends CrudRepository<Tour, Integer>{

	Tour findByTourPackageCode(String code);
	
}
