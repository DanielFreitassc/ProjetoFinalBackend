package com.unisatc.microservice_food_waste.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class FoodWaste {
    private String foodType;
    private int quantity;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
}
