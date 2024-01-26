package com.example.apetito.repository;

import com.example.apetito.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {

}
