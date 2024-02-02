package com.example.apetito.service;

import com.example.apetito.model.DishType;
import com.example.apetito.repository.DishTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DishTypeService {
    private final DishTypeRepository dishTypeRepository;

    public DishTypeService(DishTypeRepository dishTypeRepository) {
        this.dishTypeRepository = dishTypeRepository;
    }

    public DishType addDishType(DishType dishType) {
        dishTypeRepository.save(dishType);
        return dishType;
    }
    public Iterable<DishType> getAllDishTypes() {
        return dishTypeRepository.findAll();
    }
    public Optional<DishType> getDishType(Long id){
        return dishTypeRepository.findById(id);
    }


}
