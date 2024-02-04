package com.example.apetito.repository;

import com.example.apetito.model.OrderTableProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderTableProductRepository extends CrudRepository<OrderTableProduct,Long> {
    List<OrderTableProduct> findByProductRestaurantRestaurantID(Long restaurantId);
}
