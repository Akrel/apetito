package com.example.apetito.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TypPotrawy {
    @Id
    @Nonnull
    private Long idTypuPotrawy;
    @Nonnull
    @Column
    private String nazwa;
    @Nonnull
    @Column
    private byte[] zdjecie;
}
