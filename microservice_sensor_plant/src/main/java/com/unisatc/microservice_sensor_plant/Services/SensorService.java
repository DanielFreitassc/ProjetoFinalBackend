package com.unisatc.microservice_sensor_plant.Services;

import com.unisatc.microservice_sensor_plant.Models.SensorData;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SensorService {

    public SensorData getSensorData() {
        return new SensorData(
                getRandomNumberInRange(30, 100) + "%",  // umidade
                getRandomNumberInRange(15, 40) + "°C",   // temperatura
                getRandomNumberInRange(500, 1000), // nivelDeLuzSolar
                getRandomNumberInRange(10, 50) + "%"    // quantidadeDeAduboUsado
        );
    }

    private String getRandomNumberInRange(double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();    
        return String.format("%.1f", min + (max - min) * r.nextDouble());
    }
}