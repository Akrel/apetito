package com.example.apetito.service;

import com.example.apetito.model.OrderTable;
import com.example.apetito.repository.OrderTableRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderTableService {
    private final OrderTableRepository orderTableRepository;

    public OrderTableService(OrderTableRepository orderTableRepository) {
        this.orderTableRepository = orderTableRepository;
    }

    public OrderTable addOrderTable(OrderTable orderTable){
        return orderTableRepository.save(orderTable);
    }
}
