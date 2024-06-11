package com.unisatc.microservice_sensor_plant.Controllers;

import com.unisatc.microservice_sensor_plant.Models.SensorData;
import com.unisatc.microservice_sensor_plant.Services.SensorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/sensor-data")
    public SensorData getSensorData() {
        return sensorService.getSensorData();
    }
}