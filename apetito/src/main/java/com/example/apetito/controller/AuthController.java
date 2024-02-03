package com.example.apetito.controller;

import com.example.apetito.config.AuthenticationRequest;
import com.example.apetito.config.AuthenticationResponse;
import com.example.apetito.config.AuthenticationService;
import com.example.apetito.dto.ClientRegisterRequest;
import com.example.apetito.dto.DeliveryRegisterRequest;
import com.example.apetito.dto.RestaurantRegisterRequest;
import com.example.apetito.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final ClientService clientService;
    private final AuthenticationService authenticationService;

    public AuthController(ClientService clientService, AuthenticationService authenticationService) {
        this.clientService = clientService;
        this.authenticationService = authenticationService;
    }


    @PostMapping("/register/client")
    public ResponseEntity<AuthenticationResponse> registerClient(@RequestBody ClientRegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/register/delivery")
    public ResponseEntity<AuthenticationResponse> registerDelivery(@RequestBody DeliveryRegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/register/restaurant")
    public ResponseEntity<AuthenticationResponse> registerRestaurant(@RequestBody RestaurantRegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
