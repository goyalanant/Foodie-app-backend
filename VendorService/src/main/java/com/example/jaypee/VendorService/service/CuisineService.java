package com.example.jaypee.VendorService.service;

import com.example.jaypee.VendorService.domain.Cuisine;

public interface CuisineService {

    public Cuisine addCuisine(Cuisine cuisine);
    public Cuisine getCuisineById(String cuisineIds);
}
