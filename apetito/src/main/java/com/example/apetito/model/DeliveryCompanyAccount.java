package com.example.apetito.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DeliveryCompanyAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryCompanyAccountID;
    @Column
    private String login;
    @Column
    private String password;
}
