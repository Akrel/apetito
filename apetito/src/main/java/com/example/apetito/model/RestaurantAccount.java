package com.example.apetito.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RestaurantAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantAccountID;
    @Column
    private String login;
    @Column
    private String password;
}
