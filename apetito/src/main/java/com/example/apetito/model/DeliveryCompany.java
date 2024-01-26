package com.example.apetito.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DeliveryCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryCompanyID;
    @Column
    private String name;
    @JoinColumn
    @ManyToOne (fetch = FetchType.EAGER)
    private DeliveryCompanyAccount deliveryCompanyAccount;
}
