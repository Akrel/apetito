package com.example.apetito.repository;

import com.example.apetito.model.DeliveryCompanyAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeliveryCompanyAccountRepository extends CrudRepository<DeliveryCompanyAccount,Long> {
    Optional<DeliveryCompanyAccount> findByEmail(String username);
    boolean existsByEmail(String email);
}
