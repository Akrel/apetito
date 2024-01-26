package com.example.apetito.repository;

import com.example.apetito.model.DishType;
import com.example.apetito.model.RestaurantAddress;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantAddressRepository extends CrudRepository<RestaurantAddress,Long> {
}
