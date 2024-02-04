package com.example.apetito.config.userDetails;

import com.example.apetito.dto.ClientRegisterRequest;
import com.example.apetito.model.Client;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ClientRegisterRequestManager implements RegisterRequestManager<ClientRegisterRequest> {

    @Override
    public UserDetails createUserDetails(ClientRegisterRequest registerRequest,
                                         PasswordEncoder passwordEncoder) {
        Client client = new Client();
        client.setEmail(registerRequest.getUsername());
        client.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        return client;
    }
}
