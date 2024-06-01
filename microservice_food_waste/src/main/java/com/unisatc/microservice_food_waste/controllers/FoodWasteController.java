package com.unisatc.microservice_food_waste.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unisatc.microservice_food_waste.models.FoodWaste;
import com.unisatc.microservice_food_waste.services.FoodWasteService;

@RestController
@RequestMapping("/waste")
public class FoodWasteController {

    @Autowired
    private FoodWasteService foodWasteService;

    @GetMapping
    public ResponseEntity<FoodWaste> generateWaste() {
        return ResponseEntity.ok(foodWasteService.generateRandomWaste());
    }
}

