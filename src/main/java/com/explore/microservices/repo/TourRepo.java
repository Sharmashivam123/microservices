package com.explore.microservices.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.explore.microservices.domain.Tour;

@Repository
public interface TourRepo extends CrudRepository<Tour, Integer>{

	List<Tour> findByTourPackageCode(String code);
	
}
