package com.unisatc.marketplace.services;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unisatc.marketplace.dtos.WasteResponse;
import com.unisatc.marketplace.models.Waste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WasteService {

    private static final String WASTE_URI = "http://localhost:8081/waste";

    @Autowired
    private RestTemplate restTemplate;

    public List<Waste> fetchWaste() {
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                WASTE_URI,
                HttpMethod.GET,
                null,
                String.class
            );

            // Log the response body
            System.out.println("Response Body: " + response.getBody());

            // Deserialize manually for debugging
            ObjectMapper mapper = new ObjectMapper();
            WasteResponse wasteResponse = mapper.readValue(response.getBody(), WasteResponse.class);

            return wasteResponse.getData();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching waste data", e);
        }
    }
}
