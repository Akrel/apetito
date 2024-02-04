package com.example.apetito.service;

import com.example.apetito.repository.DeliveryCompanyAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeliveryCompanyAccountService implements UserDetailsService {

    private final DeliveryCompanyAccountRepository deliveryCompanyAccountRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return deliveryCompanyAccountRepository.findByEmail(email).orElseThrow();
    }
}
