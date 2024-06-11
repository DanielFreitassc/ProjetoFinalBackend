package com.unisatc.microservice_sensor_plant.Models;

public class SensorData {

    private String umidade;
    private String temperatura;
    private String nivelDeLuzSolar;
    private String quantidadeDeAduboUsado;
    
    public SensorData(String string, String string2, String string3, String string4) {
        this.umidade = string;
        this.temperatura = string2;
        this.nivelDeLuzSolar = string3;
        this.quantidadeDeAduboUsado = string4;
    }
    
    public String getUmidade() {
        return umidade;
    }
    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }
    public String getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
    public String getNivelDeLuzSolar() {
        return nivelDeLuzSolar;
    }
    public void setNivelDeLuzSolar(String nivelDeLuzSolar) {
        this.nivelDeLuzSolar = nivelDeLuzSolar;
    }
    public String getQuantidadeDeAduboUsado() {
        return quantidadeDeAduboUsado;
    }
    public void setQuantidadeDeAduboUsado(String quantidadeDeAduboUsado) {
        this.quantidadeDeAduboUsado = quantidadeDeAduboUsado;
    }

    
}