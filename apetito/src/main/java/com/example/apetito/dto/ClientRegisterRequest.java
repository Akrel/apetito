package com.example.apetito.dto;

public class ClientRegisterRequest extends RegisterRequest {
    public ClientRegisterRequest(String username, String password) {
        super(username, password);
    }

    public ClientRegisterRequest() {
    }
}
