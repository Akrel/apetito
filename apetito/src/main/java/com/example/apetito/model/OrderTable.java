package com.example.apetito.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class OrderTable {
    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;
    @Column
    private LocalDateTime orderDate;
    @Column
    private LocalDateTime orderCompletionDate;
    @Column
    private Boolean isFinished;
    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;
    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private DeliveryAddress deliveryAddress;
    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private DeliveryCompany deliveryCompany;

}
