package com.example.apetito.repository;

import com.example.apetito.model.RestaurantAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RestaurantAccountRepository extends CrudRepository<RestaurantAccount,Long> {
    Optional<RestaurantAccount> findByEmail(String login);
    boolean existsByEmail(String email);
}
