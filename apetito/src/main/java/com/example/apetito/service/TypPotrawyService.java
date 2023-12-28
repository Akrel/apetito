package com.example.apetito.service;

import com.example.apetito.model.TypPotrawy;
import com.example.apetito.repository.TypPotrawyRepository;
import org.springframework.stereotype.Service;


@Service
public class TypPotrawyService {
    private final TypPotrawyRepository typPotrawyRepository;

    public TypPotrawyService(TypPotrawyRepository typPotrawyRepository) {
        this.typPotrawyRepository = typPotrawyRepository;
    }

    public void addTypPotrawy(TypPotrawy typPotrawy) {
        typPotrawyRepository.save(typPotrawy);
    }
    public Iterable<TypPotrawy> getAllTypPotrawy() {
        return typPotrawyRepository.findAll();
    }


}
