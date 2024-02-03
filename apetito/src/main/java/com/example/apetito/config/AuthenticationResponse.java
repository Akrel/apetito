package com.example.apetito.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class AuthenticationResponse {

    private final String jwtToken;

}
