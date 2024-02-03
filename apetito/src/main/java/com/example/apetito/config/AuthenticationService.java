package com.example.apetito.config;

import com.example.apetito.config.userDetails.ClientRegisterRequestManager;
import com.example.apetito.config.userDetails.RegisterRequestManager;
import com.example.apetito.dto.ClientRegisterRequest;
import com.example.apetito.dto.RegisterRequest;
import com.example.apetito.model.Client;
import com.example.apetito.model.DeliveryCompanyAccount;
import com.example.apetito.model.RestaurantAccount;
import com.example.apetito.repository.ClientRepository;
import com.example.apetito.repository.DeliveryCompanyAccountRepository;
import com.example.apetito.repository.RestaurantAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final ClientRepository clientRepository;
    private final DeliveryCompanyAccountRepository deliveryCompanyAccountRepository;
    private final RestaurantAccountRepository restaurantAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        RegisterRequestManager clientRegisterRequestManager = null;
        if (request instanceof ClientRegisterRequest) {
            clientRegisterRequestManager = new ClientRegisterRequestManager();
        }

        UserDetails userDetails = clientRegisterRequestManager.createUserDetails(request, passwordEncoder);

        if (userDetails instanceof RestaurantAccount restaurantAccount)
            restaurantAccountRepository.save(restaurantAccount);
        else if (userDetails instanceof Client client)
            clientRepository.save(client);
        else if (userDetails instanceof DeliveryCompanyAccount deliveryCompanyAccount)
            deliveryCompanyAccountRepository.save(deliveryCompanyAccount);


        Map<String, Object> extraclaims = new HashMap<>();

        System.err.println(userDetails.getAuthorities());
        userDetails.getAuthorities().stream().forEach(authority -> {
            extraclaims.put("authority", authority);
        });

        String jwtToken = jwtService.generateToken(extraclaims, userDetails);

        return new AuthenticationResponse(jwtToken);
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails details = clientRepository.findByEmail(request.getUsername()).orElse(null);

        if (details == null)
            details = restaurantAccountRepository.findByLogin(request.getUsername()).orElse(null);
     /*   else {
            details = deliveryCompanyAccountRepository.findByLogin(request.getUsername()).orElseThrow(null);
        }
*/
        String jwtToken = jwtService.generateToken(details);

        return new AuthenticationResponse(jwtToken);
    }

}
