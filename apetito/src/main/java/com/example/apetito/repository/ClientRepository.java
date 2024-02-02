package com.example.apetito.repository;


import com.example.apetito.model.Client;
import com.example.apetito.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client,Long> {
    Optional<Client> findByEmail(String email);
}
