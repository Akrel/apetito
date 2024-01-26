package com.example.apetito.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderTableProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderProductID;
    @Column
    private int number;
    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private OrderTable order;
}