package com.explore.microservices.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.explore.microservices.domain.Tour;

@Repository
public interface TourRepo extends PagingAndSortingRepository<Tour, Integer>{

	Page<Tour> findByTourPackageCode(String code, org.springframework.data.domain.Pageable pageable);
	
}
