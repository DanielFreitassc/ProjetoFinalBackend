package com.unisatc.marketplace.dtos;

import java.time.LocalDate;
import lombok.Data;

@Data
public class WasteResponse {
    private String foodType;
    private int quantity;
    private LocalDate date;
}
