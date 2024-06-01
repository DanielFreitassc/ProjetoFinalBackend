package com.unisatc.microservice_food_waste.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.unisatc.microservice_food_waste.models.FoodWaste;

@Service
public class FoodWasteService {
    
    private final List<String> foodTypes = Arrays.asList("Milho", "Soja", "Arroz", "Alface");

    public FoodWaste generateRandomWaste() {
        Random random = new Random();
        FoodWaste waste = new FoodWaste();
        waste.setFoodType(foodTypes.get(random.nextInt(foodTypes.size())));
        waste.setQuantity(random.nextInt(100));
        waste.setDate(LocalDate.now());
        return waste;
    }
}

