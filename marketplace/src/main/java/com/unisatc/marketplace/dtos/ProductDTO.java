package com.unisatc.marketplace.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(
    Long id,
    @NotBlank(message = "O campo nome não pode ser vazio ou nulo")
    String name,
    @NotNull(message = "O preço não pode ser nulo")
    Double price,
    @NotBlank(message = "O campo descrição não pode ser vazio ou nulo")
    String description,
    @NotNull(message = "O campo validade não pode ser nulo")
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate validity
) {

}
