package com.explore.microservices.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.explore.microservices.domain.TourPackage;

@Repository
public interface TourPackageRepo extends CrudRepository<TourPackage, String>{

	Optional<TourPackage> findByName(String name);

}
