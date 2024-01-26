package com.example.apetito.service;

import com.example.apetito.model.DishType;
import com.example.apetito.model.Restaurant;
import com.example.apetito.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Iterable<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }
}
