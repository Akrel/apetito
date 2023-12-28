package com.example.apetito.controler;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ApiController {

    @GetMapping("/data")
    public String getData() {
        return "Hello from the backend!";
    }
    @GetMapping("/promotions")
    public String getData2() {
        return "Hello from the backend!";
    }
}
