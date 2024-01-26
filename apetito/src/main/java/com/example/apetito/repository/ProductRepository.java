package com.example.apetito.repository;

import com.example.apetito.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
    Iterable<Product> findByRestaurantRestaurantID(Long restaurantID);
}
