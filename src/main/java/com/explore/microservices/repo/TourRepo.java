package com.explore.microservices.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.explore.microservices.domain.Tour;

@RepositoryRestResource(collectionResourceRel = "packages", path = "packages")
public interface TourRepo extends PagingAndSortingRepository<Tour, Integer>{

	@Override
	@RestResource(exported = false)
	default <S extends Tour> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RestResource(exported = false)
	default <S extends Tour> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RestResource(exported = false)
	default void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void delete(Tour entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void deleteAll(Iterable<? extends Tour> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	Page<Tour> findByTourPackageCode(String code, org.springframework.data.domain.Pageable pageable);
	
}
