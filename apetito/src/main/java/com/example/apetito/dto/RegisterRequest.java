package com.example.apetito.dto;

import lombok.*;

//todo
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class RegisterRequest {

    private String username;
    private String password;


}
