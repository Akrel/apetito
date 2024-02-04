package com.example.apetito.dto;

public class ClientRegisterRequest extends RegisterRequest {
    public ClientRegisterRequest(String username, String password,String name, String surname) {
        super(username, password);
    }

    public ClientRegisterRequest() {
    }
}
