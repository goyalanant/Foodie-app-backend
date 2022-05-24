package com.example.jaypee.CartService.service;

import com.example.jaypee.CartService.domain.Cart;
import com.example.jaypee.CartService.domain.CartItem;
import com.example.jaypee.CartService.domain.Dish;
import com.example.jaypee.CartService.domain.User;

import java.util.List;

public interface CartService {

    public User addUser(User user);
    public User updateUser(User user,String userId);
    public User addDishToCart(CartItem item, String userId) ;
    public List<CartItem> getCartDetails(String userID);

    public CartItem increaseCartItemQuantity(Dish dish, String userId);
    public CartItem decreaseCartItemQuantity(Dish dish, String userId);
    public CartItem deleteCartItem(Dish dish, String userId);
    public Cart getTotalCartAmount(Cart cart,String userId);
    public Cart addDishToCartItem(Dish dish, String userId, int quantity);
    public User emptyCart(String userId);
}
