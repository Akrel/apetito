package com.example.apetito.service;

import com.example.apetito.model.OrderTable;
import com.example.apetito.repository.OrderTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTableService {
    private final OrderTableRepository orderTableRepository;

    public OrderTableService(OrderTableRepository orderTableRepository) {
        this.orderTableRepository = orderTableRepository;
    }

    public OrderTable addOrderTable(OrderTable orderTable){
        return orderTableRepository.save(orderTable);
    }

    public List<OrderTable> getOrdersByClientId(Long id) {
        return orderTableRepository.findByClientClientID(id);
    }

    public List<OrderTable> getOrdersByDeliveryCompanyId(Long id) {
        // Wywołaj repozytorium, aby pobrać zamówienia dostawcze dla danej firmy dostawczej
        return orderTableRepository.findByDeliveryCompanyDeliveryCompanyID(id);
    }

}
