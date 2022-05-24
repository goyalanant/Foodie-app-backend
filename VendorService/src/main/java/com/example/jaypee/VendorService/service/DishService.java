package com.example.jaypee.VendorService.service;

import com.example.jaypee.VendorService.domain.Dish;
import com.example.jaypee.VendorService.domain.Restaurant;
import com.example.jaypee.VendorService.exception.DishNotFoundException;
import com.example.jaypee.VendorService.exception.RestaurantNotFoundException;

import java.util.List;

public interface DishService {

    public Restaurant addDish(Dish dish, String restaurantId) throws RestaurantNotFoundException;
    public Restaurant deleteDish(String dishId, String restaurantId) throws RestaurantNotFoundException;
    public List<Dish> getAllDish(String restaurantId) throws RestaurantNotFoundException;
    public Dish getDishByDishId(String dishId,String restaurantId) throws RestaurantNotFoundException, DishNotFoundException;
}
