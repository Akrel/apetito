package com.example.apetito.dto;

import lombok.*;

//todo
@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    private String username;
    private String password;
}
