package com.example.apetito.config.userDetails;

import com.example.apetito.dto.ClientRegisterRequest;
import com.example.apetito.dto.DeliveryRegisterRequest;
import com.example.apetito.dto.RestaurantRegisterRequest;
import com.example.apetito.model.DeliveryCompanyAccount;
import com.example.apetito.model.RestaurantAccount;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RestaurantRegisterRequestManager implements RegisterRequestManager<RestaurantRegisterRequest>{
    @Override
    public UserDetails createUserDetails(RestaurantRegisterRequest registerRequest, PasswordEncoder passwordEncoder) {
        RestaurantAccount restaurantAccount = new RestaurantAccount();
        restaurantAccount.setEmail(registerRequest.getUsername());
        restaurantAccount.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        return restaurantAccount;
    }
}
