package com.unisatc.marketplace.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.unisatc.marketplace.dtos.SensorResponse;

@Service
public class SensorService {
    public SensorResponse sensorSearch() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SensorResponse> resp = restTemplate.getForEntity("http://microservice-sensor-plant:8082/sensor-data", SensorResponse.class);
        SensorResponse sensorResponse = resp.getBody();

        if(sensorResponse != null) {
            String umidade = sensorResponse.getUmidade();
            String temperatura = sensorResponse.getTemperatura();
            String nivelDeLuzSolar = sensorResponse.getNivelDeLuzSolar();
            String quantidadeDeAduboUsado = sensorResponse.getQuantidadeDeAduboUsado();

            String umidadeMensagem;
            String temperaturaMensagem;
            String nivelDeLuzSolarMensagem;
            String quantidadeDeAduboUsadoMensagem;

            double umidadeValor = Double.parseDouble(umidade.replace("%", ""));
            if (umidadeValor < 30) {
                umidadeMensagem = "Umidade baixa. Regue a planta.";
            } else if (umidadeValor > 70) {
                umidadeMensagem = "Umidade alta. Reduza a quantidade de água.";
            } else {
                umidadeMensagem = "Umidade em nível adequado.";
            }

            double temperaturaValor = Double.parseDouble(temperatura);
            if (temperaturaValor < 15) {
                temperaturaMensagem = "Temperatura baixa. Proteja a planta do frio.";
            } else if (temperaturaValor > 30) {
                temperaturaMensagem = "Temperatura alta. Proteja a planta do calor excessivo.";
            } else {
                temperaturaMensagem = "Temperatura em nível adequado.";
            }

            double nivelDeLuzSolarValor = Double.parseDouble(nivelDeLuzSolar);
            if (nivelDeLuzSolarValor < 300) {
                nivelDeLuzSolarMensagem = "Nível de luz solar baixo. Mova a planta para um local mais iluminado.";
            } else if (nivelDeLuzSolarValor > 1000) {
                nivelDeLuzSolarMensagem = "Nível de luz solar alto. Proteja a planta da luz direta.";
            } else {
                nivelDeLuzSolarMensagem = "Nível de luz solar em nível adequado.";
            }

            double quantidadeDeAduboUsadoValor = Double.parseDouble(quantidadeDeAduboUsado);
            if (quantidadeDeAduboUsadoValor < 50) {
                quantidadeDeAduboUsadoMensagem = "Pouco adubo utilizado. Adicione mais adubo.";
            } else if (quantidadeDeAduboUsadoValor > 150) {
                quantidadeDeAduboUsadoMensagem = "Excesso de adubo. Reduza a quantidade de adubo usado.";
            } else {
                quantidadeDeAduboUsadoMensagem = "Quantidade de adubo usada em nível adequado.";
            }

            sensorResponse.setUmidade(String.format("%.2f%%", umidadeValor));
            sensorResponse.setTemperatura(String.format("%.2f°C", temperaturaValor));
            sensorResponse.setNivelDeLuzSolar(String.valueOf(nivelDeLuzSolarValor));
            sensorResponse.setQuantidadeDeAduboUsado(String.format("%.2f%%", quantidadeDeAduboUsadoValor));

            sensorResponse.setUmidadeMensagem(umidadeMensagem);
            sensorResponse.setTemperaturaMensagem(temperaturaMensagem);
            sensorResponse.setNivelDeLuzSolarMensagem(nivelDeLuzSolarMensagem);
            sensorResponse.setQuantidadeDeAduboUsadoMensagem(quantidadeDeAduboUsadoMensagem);
        } else {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Serviço fora do ar");
        }
        return sensorResponse;
    }
}
