package com.example.jaypee.CartService.service;

import com.example.jaypee.CartService.domain.Favourite;
import com.example.jaypee.CartService.domain.Restaurant;
import com.example.jaypee.CartService.domain.User;

import java.util.List;

public interface FavouriteService {

    public Favourite addRestaurantToFavourite(Restaurant restaurant, String userId);
    //    public Favourite deleteRestaurant(String restaurantId,String userId);
    //public Favourite addRestaurantFavourite(String restaurantId,String UserId);;
    public List<Restaurant> getAllFavourite(String userId);
    public User removeRestaurantFavourite(String restaurantId,String userId);
}
