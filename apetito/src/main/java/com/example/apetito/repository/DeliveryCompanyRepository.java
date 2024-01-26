package com.example.apetito.repository;

import com.example.apetito.model.DeliveryCompany;
import com.example.apetito.model.DishType;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryCompanyRepository extends CrudRepository<DeliveryCompany,Long> {
}
