package com.example.jaypee.CartService.controllers;

import com.example.jaypee.CartService.domain.CartItem;
import com.example.jaypee.CartService.domain.Dish;
import com.example.jaypee.CartService.domain.Restaurant;
import com.example.jaypee.CartService.domain.User;
import com.example.jaypee.CartService.service.CartService;
import com.example.jaypee.CartService.service.FavouriteService;
import com.example.jaypee.CartService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/v5/cart/")
@CrossOrigin
public class CartServiceController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private FavouriteService favouriteService;

    private ResponseEntity responseEntity;


    @PostMapping("addUser")
    public  ResponseEntity<?> addUser(@RequestBody User user){

        responseEntity = new ResponseEntity<>(cartService.addUser(user),HttpStatus.OK);

        return responseEntity;
    }
    @PostMapping("updateUser/{userId}")
    public  ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String userId){

        responseEntity = new ResponseEntity<>(cartService.updateUser(user,userId),HttpStatus.OK);

        return responseEntity;
    }

    @PostMapping("addDishToCartItem/{userId}/{quantity}")
    public ResponseEntity<?> addDishToCartItem(@RequestBody Dish dish, @PathVariable String userId, @PathVariable int quantity)
    {
        responseEntity = new ResponseEntity<>(cartService.addDishToCartItem(dish,userId,quantity),HttpStatus.OK);
        return  responseEntity;
    }
    @PostMapping("addDishToCart/{userId}")
    public ResponseEntity<?> addDishToCart(@RequestBody CartItem item, @PathVariable String userId){

        responseEntity = new ResponseEntity<>(cartService.addDishToCart(item,userId), HttpStatus.OK);

        return responseEntity;

    }

    @GetMapping("getCartDetails/{userId}")
    public ResponseEntity<?> getCartDetails(@PathVariable String userId){

        responseEntity = new ResponseEntity<>(cartService.getCartDetails(userId),HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("getAllUsers")
    public ResponseEntity<?> getAllUsers(){
        responseEntity = new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("getUserByEmail/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable  String email){
        responseEntity = new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
        return responseEntity;
    }
    @PostMapping("addFavourite/{userId}")
    public ResponseEntity<?> addFavouriteRestaurant(@RequestBody Restaurant restaurant, @PathVariable String userId){
        responseEntity = new ResponseEntity<>(favouriteService.addRestaurantToFavourite(restaurant,userId),HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("getAllFavourite/{userId}")
    public ResponseEntity<?> getFavouriteRestaurant(@PathVariable String userId){
        responseEntity = new ResponseEntity<>(favouriteService.getAllFavourite(userId),HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("emptyCart/{userId}")
    public ResponseEntity<?> emptyCartItemList(@PathVariable String userId){
        responseEntity = new ResponseEntity<>(cartService.emptyCart(userId),HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("deleteFavourite/{restaurantId}/{userId}")
    public ResponseEntity<?> deleteRestaurantFromFavourite(@PathVariable String restaurantId,@PathVariable String userId){
        responseEntity = new ResponseEntity<>(favouriteService.removeRestaurantFavourite(restaurantId,userId),HttpStatus.OK);
        return responseEntity;
    }
}
