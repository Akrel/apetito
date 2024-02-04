package com.example.apetito.service;

import com.example.apetito.repository.RestaurantAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantAccountService implements UserDetailsService {

    private final RestaurantAccountRepository restaurantAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return restaurantAccountRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}
