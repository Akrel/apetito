package com.example.apetito.service;

import com.example.apetito.model.Client;
import com.example.apetito.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> findClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }


}
