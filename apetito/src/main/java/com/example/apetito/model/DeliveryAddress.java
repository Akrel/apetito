package com.example.apetito.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DeliveryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryAddressID;
    @Column
    private String street;
    @Column
    private String buildingNumber;
    @Column
    private String zipCode;
    @Column
    private String NIP;
    @Column
    private String gateCode;
    @Column
    private int floor;
    @Column
    private String companyName;
    @Column
    private String note;
}
