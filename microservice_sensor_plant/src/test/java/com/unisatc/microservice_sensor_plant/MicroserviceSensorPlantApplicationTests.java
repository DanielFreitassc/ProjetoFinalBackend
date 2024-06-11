package com.unisatc.microservice_sensor_plant;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.unisatc.microservice_sensor_plant.Models.SensorData;
import com.unisatc.microservice_sensor_plant.Services.SensorService;

@SpringBootTest
class MicroserviceSensorPlantApplicationTests {

	private final SensorService sensorService = new SensorService();
	@Test
	public void testGetSensorData() {
        SensorData sensorData = sensorService.getSensorData();
        assertNotNull(sensorData.getUmidade());
        assertNotNull(sensorData.getTemperatura());
        assertNotNull(sensorData.getNivelDeLuzSolar());
        assertNotNull(sensorData.getQuantidadeDeAduboUsado());
    }
}