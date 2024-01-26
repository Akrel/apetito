package com.example.apetito.repository;

import com.example.apetito.model.OrderTableProduct;
import org.springframework.data.repository.CrudRepository;

public interface OrderTableProductRepository extends CrudRepository<OrderTableProduct,Long> {
}
