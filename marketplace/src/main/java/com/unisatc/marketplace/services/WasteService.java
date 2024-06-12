package com.unisatc.marketplace.services;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.unisatc.marketplace.dtos.WasteResponse;


@Service
public class WasteService {
    public WasteResponse wasteSearch() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WasteResponse> resp = restTemplate.getForEntity("http://microservice-food-waste-backend:8081/waste", WasteResponse.class);
        WasteResponse wasteResponse = resp.getBody();

        if (wasteResponse != null) {
            int quantity = wasteResponse.getQuantity();
            String alertMessage;

            if (quantity < 20) {
                alertMessage = "Alerta: Quantidade de disperdicio do produto: " + wasteResponse.getFoodType() + " é menor que 20. Data: " + wasteResponse.getDate();
            } else if (quantity >= 20 && quantity < 50) {
                alertMessage = "Quantidade de disperdicio do produto: " + wasteResponse.getFoodType() + " é moderada. Data: " + wasteResponse.getDate();
            } else {
                alertMessage = "Quantidade de disperdicio do produto: " + wasteResponse.getFoodType() + " é alta. Data: " + wasteResponse.getDate();
            }

            wasteResponse.setAlertMessage(alertMessage);
        } else {
            wasteResponse = new WasteResponse();
            wasteResponse.setAlertMessage("Erro: Não foi possível obter os dados de desperdício.");
        }

        return wasteResponse;
    }
}
