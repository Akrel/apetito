package com.example.apetito.service;

import com.example.apetito.model.OrderTableProduct;
import com.example.apetito.repository.OrderTableProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTableProductService {
    private final OrderTableProductRepository orderTableProductRepository;

    public OrderTableProductService(OrderTableProductRepository orderTableProductRepository) {
        this.orderTableProductRepository = orderTableProductRepository;
    }
    public OrderTableProduct addOrderTableProduct (OrderTableProduct orderTableProduct){
        return orderTableProductRepository.save(orderTableProduct);
    }

    public List<OrderTableProduct> ordersForRestaurant(Long id){
        return orderTableProductRepository.findByProductRestaurantRestaurantID(id);
    };
}
