package com.example.jaypee.VendorService.repository;

import com.example.jaypee.VendorService.domain.Cuisine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends MongoRepository<Cuisine, String> {
}
