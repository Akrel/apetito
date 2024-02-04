package com.example.apetito.controller;

import com.example.apetito.model.Restaurant;
import com.example.apetito.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/restaurants")
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/all")
    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurant();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurant(id);
        return restaurant.map(ResponseEntity::ok).orElseGet (() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<Resource> getRestaurantImage(@PathVariable Long id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurant(id);
        if (restaurant.isPresent()) {
            String imageName = restaurant.get().getResultPhotoUrl();
            Resource resource = new ClassPathResource("photos/restaurant/" + imageName);
            return ResponseEntity.ok().body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/banner/{id}")
    public ResponseEntity<Resource> getRestaurantBanner(@PathVariable Long id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurant(id);
        if (restaurant.isPresent()) {
            String imageName = restaurant.get().getBannerUrl();
            Resource resource = new ClassPathResource("photos/restaurant/banner/" + imageName);
            return ResponseEntity.ok().body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
