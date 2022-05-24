package com.example.jaypee.VendorService.service;

import com.example.jaypee.VendorService.domain.Cuisine;
import com.example.jaypee.VendorService.repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CuisineServiceImpl implements CuisineService {

    @Autowired
    private CuisineRepository cuisineRepository;


    @Override
    public Cuisine addCuisine(Cuisine cuisine) {

        cuisine.setCuisineId(UUID.randomUUID().toString());
        return cuisineRepository.save(cuisine);
    }

    @Override
    public Cuisine getCuisineById(String cuisineIds) {

        Cuisine cuisine = cuisineRepository.findById(cuisineIds).get();

        return  cuisine;
    }
}
