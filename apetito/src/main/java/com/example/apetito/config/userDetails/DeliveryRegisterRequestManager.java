package com.example.apetito.config.userDetails;

import com.example.apetito.dto.DeliveryRegisterRequest;
import com.example.apetito.model.DeliveryCompany;
import com.example.apetito.model.DeliveryCompanyAccount;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DeliveryRegisterRequestManager implements RegisterRequestManager<DeliveryRegisterRequest> {
    @Override
    public UserDetails createUserDetails(DeliveryRegisterRequest registerRequest, PasswordEncoder passwordEncoder) {
        DeliveryCompanyAccount deliveryCompanyAccount = new DeliveryCompanyAccount();
        deliveryCompanyAccount.setEmail(registerRequest.getUsername());
        deliveryCompanyAccount.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        return deliveryCompanyAccount;
    }
}
