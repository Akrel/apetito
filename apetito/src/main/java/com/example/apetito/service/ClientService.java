package com.example.apetito.service;

import com.example.apetito.model.Client;
import com.example.apetito.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService implements UserDetailsService {

    private final ClientRepository clientRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return clientRepository.findByEmail(username).orElse(null);
    }

    public Optional<Client> findClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public boolean existsByEmail(String email){
        return clientRepository.existsByEmail(email);
    }

    public Long findClientIdByEmail(String email) {
        return clientRepository.findByEmail(email).orElseThrow().getClientID();
    }
}