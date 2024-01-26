package com.example.apetito.repository;

import com.example.apetito.model.DeliveryAddress;
import com.example.apetito.model.DishType;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryAddressRepository extends CrudRepository<DeliveryAddress,Long> {
}
