package com.example.apetito.service;

import com.example.apetito.model.DeliveryCompany;
import com.example.apetito.repository.DeliveryCompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryCompanyService {
    private final DeliveryCompanyRepository deliveryCompanyRepository;

    public DeliveryCompanyService(DeliveryCompanyRepository deliveryCompanyRepository) {
        this.deliveryCompanyRepository = deliveryCompanyRepository;
    }

    public Optional<DeliveryCompany> getDeliveryCompanyByID(Long id){
        return deliveryCompanyRepository.findById(id);
    }
    public Iterable<DeliveryCompany> getAllDishTypes() {
        return deliveryCompanyRepository.findAll();
    }
}
