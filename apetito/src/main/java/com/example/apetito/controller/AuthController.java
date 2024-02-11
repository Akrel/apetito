package com.example.apetito.controller;

import com.example.apetito.dto.AuthenticationRequest;
import com.example.apetito.config.AuthenticationResponse;
import com.example.apetito.config.AuthenticationService;
import com.example.apetito.dto.ClientRegisterRequest;
import com.example.apetito.dto.DeliveryRegisterRequest;
import com.example.apetito.dto.RestaurantRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register/client")
    public ResponseEntity<?> registerClient(@RequestBody ClientRegisterRequest request) {
        try {
            AuthenticationResponse response = authenticationService.register(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Wewnętrzny błąd serwera."));
        }
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


    /*
    if(clientRepository.existsByEmail(request.getUsername())
                || restaurantAccountRepository.existsByEmail(request.getUsername())
                || deliveryCompanyAccountRepository.existsByEmail(request.getUsername())){
            return ResponseEntity
                    .badRequest()
                    .body(new AuthenticationResponse(null, "Email jest już używany."));
        }
     */
}
