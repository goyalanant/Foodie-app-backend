package com.example.jaypee.CartService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    private Dish dish;
    private int dishQuantity;
    private String restaurantId;
}
