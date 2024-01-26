package com.example.apetito.service;

import com.example.apetito.model.DeliveryAddress;
import com.example.apetito.repository.DeliveryAddressRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryAddressService {
    private final DeliveryAddressRepository deliveryAddressRepository;

    public DeliveryAddressService(DeliveryAddressRepository deliveryAddressRepository) {
        this.deliveryAddressRepository = deliveryAddressRepository;
    }

    public DeliveryAddress addDeliveryAddress(DeliveryAddress deliveryAddress) {
        return deliveryAddressRepository.save(deliveryAddress);
    }
}
