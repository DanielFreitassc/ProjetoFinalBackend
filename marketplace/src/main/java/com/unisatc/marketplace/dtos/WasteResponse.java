package com.unisatc.marketplace.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class WasteResponse {
    private String foodType;
    private int quantity;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private transient String alertMessage;
}
