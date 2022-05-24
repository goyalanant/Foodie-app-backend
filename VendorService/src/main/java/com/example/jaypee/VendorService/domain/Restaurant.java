package com.example.jaypee.VendorService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    private String restaurantId;
    private String restaurantVendorId;
    private String restaurantName;
    private List<String> restaurantImages;
    private List<String> cuisineIds;
    private List<Dish>dishList;
    private Location restaurantLocation;
}
