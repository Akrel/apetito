package com.example.apetito.config.userDetails;

import com.example.apetito.dto.DeliveryRegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DeliveryRegisterRequestManager implements RegisterRequestManager<DeliveryRegisterRequest> {
    @Override
    public UserDetails createUserDetails(DeliveryRegisterRequest registerRequest, PasswordEncoder passwordEncoder) {
        return null;
    }
}
