package com.unisatc.marketplace.models;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Waste {
    private Long id;
    private String foodType;
    private Double quantity;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
}
