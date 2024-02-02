package com.example.apetito.controller;

import com.example.apetito.model.DishType;
import com.example.apetito.service.DishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/dishTypes")
@CrossOrigin(origins = "http://localhost:3000")
public class DishTypeController {

    private final DishTypeService dishTypeService;

    @Autowired
    public DishTypeController(DishTypeService dishTypeService) {
        this.dishTypeService = dishTypeService;
    }

    @GetMapping("/all")
    public Iterable<DishType> getAllDishTypes() {
        return dishTypeService.getAllDishTypes();
    }

    @PostMapping("/add")
    public ResponseEntity<DishType> addDishType(@RequestBody DishType dishType) {
        DishType newDishType = dishTypeService.addDishType(dishType);
        return ResponseEntity.ok(newDishType);
    }
    /*
    @PutMapping("/update/{id}")
    public ResponseEntity<DishType> updateDishType(@PathVariable Long id, @RequestBody DishType dishTypeDetails) {
        DishType updatedDishType = dishTypeService.updateDishType(id, dishTypeDetails);
        return updatedDishType != null ? ResponseEntity.ok(updatedDishType) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDishType(@PathVariable Long id) {
        boolean deleted = dishTypeService.deleteDishType(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
*/
    @GetMapping("/image/{id}")
    public ResponseEntity<Resource> getDishTypeImage(@PathVariable Long id) {
        Optional<DishType> dishType = dishTypeService.getDishType(id);
        if (dishType.isPresent()) {
            String imageName = dishType.get().getPhotoUrl();
            Resource resource = new ClassPathResource("photos/dishType/" + imageName);
            return ResponseEntity.ok().body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Możesz dodać więcej metod związanych z operacjami na typach dań
}
