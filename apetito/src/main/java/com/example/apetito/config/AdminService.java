package com.example.apetito.config;

import com.example.apetito.repository.RestaurantAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService implements UserDetailsService {

    private final RestaurantAccountRepository restaurantAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return restaurantAccountRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}
