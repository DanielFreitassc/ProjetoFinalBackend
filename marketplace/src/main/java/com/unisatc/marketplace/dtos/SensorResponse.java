package com.unisatc.marketplace.dtos;

import lombok.Data;

@Data
public class SensorResponse {
    private String umidade;
    private String temperatura;
    private String nivelDeLuzSolar;
    private String quantidadeDeAduboUsado;
    private String umidadeMensagem;
    private String temperaturaMensagem;
    private String nivelDeLuzSolarMensagem;
    private String quantidadeDeAduboUsadoMensagem;

}
