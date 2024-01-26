package com.example.apetito.service;

import com.example.apetito.model.DishType;
import com.example.apetito.model.Product;
import com.example.apetito.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){this.productRepository = productRepository;}

    public Iterable<Product> getRestaurantMenu(Long restaurantId){
        return productRepository.findByRestaurantRestaurantID(restaurantId);
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }
}
