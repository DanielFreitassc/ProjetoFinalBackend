package com.unisatc.marketplace.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class Estudantes {
    
    private List<String> estudantes = new ArrayList<>(Arrays.asList("Daniel Freitas","Geanlucca Zappe"));
    private String projeto = "Agricultura e Segurança Alimentar";
    private String tema = "Marketplace ";
}
