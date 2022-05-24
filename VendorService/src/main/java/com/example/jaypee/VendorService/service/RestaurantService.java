package com.example.jaypee.VendorService.service;

import com.example.jaypee.VendorService.domain.Location;
import com.example.jaypee.VendorService.domain.Restaurant;
import com.example.jaypee.VendorService.domain.Vendor;
import com.example.jaypee.VendorService.exception.RestaurantNotFoundException;
import com.example.jaypee.VendorService.exception.VendorNotFoundException;

import java.util.List;

public interface RestaurantService {


    public Restaurant addRestaurantDetails(Restaurant restaurant, String vendorId) throws VendorNotFoundException;
    public Vendor deleteRestaurantDetails(String vendorId) throws VendorNotFoundException, RestaurantNotFoundException;
    public Restaurant editRestaurantDetails(Restaurant restaurant,String vendorId) throws VendorNotFoundException,RestaurantNotFoundException ;
    public Restaurant addRestaurantLocation(Location location, String vendorId) throws VendorNotFoundException,RestaurantNotFoundException;
    public List<Restaurant> getAllRestaurant();
    public Restaurant getRestaurantByResId(String restaurantId) throws RestaurantNotFoundException;
    public Restaurant getRestaurantByName(String restaurantName);
//    public Restaurant addDish(Dish dish, String restaurantId) throws RestaurantNotFoundException ;
//
//    public Restaurant deleteDish(String dishId , String restaurantId) throws RestaurantNotFoundException;
}
