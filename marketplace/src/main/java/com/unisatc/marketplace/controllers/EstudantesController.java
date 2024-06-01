package com.unisatc.marketplace.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unisatc.marketplace.models.Estudantes;

@RestController
@RequestMapping("ajuda")
public class EstudantesController {

    @GetMapping
    public ResponseEntity<Estudantes> getAllEstudantes() {
        Estudantes estudantes = new Estudantes();
        return ResponseEntity.status(HttpStatus.OK).body(estudantes);
    }
    
}
