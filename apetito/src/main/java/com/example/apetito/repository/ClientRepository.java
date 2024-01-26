package com.example.apetito.repository;


import com.example.apetito.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
}
