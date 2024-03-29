package com.example.apetito.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataToCreateOrder {
    private String street;
    private String buildingNumber;
    private String zipCode;
    private String NIP;
    private String gateCode;
    private int floor;
    private String companyName;
    private String note;
    private String name;
    private String surname;
    private String email;
    private int phoneNumber;
    private Long deliveryCompanyID;
    private List<CartItem> cartItems;
}
