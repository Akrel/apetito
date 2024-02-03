package com.example.apetito.config.userDetails;

import com.example.apetito.dto.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface RegisterRequestManager<REGISTER_REQUEST extends RegisterRequest> {

    UserDetails createUserDetails(REGISTER_REQUEST registerRequest, PasswordEncoder passwordEncoder);


}
