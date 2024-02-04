package com.example.apetito.repository;

import com.example.apetito.model.OrderTable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderTableRepository extends CrudRepository<OrderTable,Long> {
    List<OrderTable> findByClientClientID(Long id);
    List<OrderTable> findByDeliveryCompanyDeliveryCompanyID(Long id);
}
