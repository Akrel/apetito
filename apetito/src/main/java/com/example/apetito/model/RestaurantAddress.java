package com.example.apetito.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RestaurantAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantAddressID;
    @Column
    private String street;
    @Column
    private String buildingNumber;
    @Column
    private String city;
    @Column
    private String zipCode;
}
