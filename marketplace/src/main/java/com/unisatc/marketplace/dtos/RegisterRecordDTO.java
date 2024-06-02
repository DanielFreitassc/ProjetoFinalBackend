package com.unisatc.marketplace.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import com.unisatc.marketplace.models.UserRole;

public record RegisterRecordDTO(
    @NotBlank String name, 
    @NotBlank
    @Column(unique = true,nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9._+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "O formato do e-mail inserido é inválido.")
    String login, 
    @NotBlank 
    @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z]).*$", message = "A senha precisa ter pelo menos um caractere maiúsculo e um caractere minúsculo.")
    String password, 
    @NotNull UserRole role
    ) {
    
}
