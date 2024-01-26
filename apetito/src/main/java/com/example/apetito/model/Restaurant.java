package com.example.apetito.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantID;
    @Column
    private String name;
    @Column
    private String resultPhotoUrl;
    @Column
    private String logoUrl;
    @Column
    private String bannerUrl;
    @JoinColumn
    @OneToOne (fetch = FetchType.EAGER)
    private RestaurantAddress restaurantAddress;
    @JoinColumn
    @OneToOne (fetch = FetchType.EAGER)
    private RestaurantAccount restaurantAccount;
}
