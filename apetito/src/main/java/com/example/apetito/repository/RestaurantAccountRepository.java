package com.example.apetito.repository;

import com.example.apetito.model.DishType;
import com.example.apetito.model.RestaurantAccount;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantAccountRepository extends CrudRepository<RestaurantAccount,Long> {
}
