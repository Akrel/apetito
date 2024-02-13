package com.example.apetito.config;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthenticationResponse {
    private String jwtToken;
    private String message;
}
