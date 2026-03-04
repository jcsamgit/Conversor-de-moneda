package com.githubjcsam.conversor.service;

import com.githubjcsam.conversor.modelo.Moneda;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorService {
    private static final String API_KEY = "781800f1a7e03848d3b46784";
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6";

    private final HttpClient client;

    public  ConversorService(){
        this.client = HttpClient.newHttpClient();
    }

    public double convertir (Moneda base, Moneda destino, double cantidad) throws IOException, InterruptedException {

        String url = URL_BASE + API_KEY + "/lasted/" + base.getCodigo();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200){
            throw new RuntimeException("Error en la API: " + response.statusCode());
        }

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("Conversion_rates");

        double tasa = rates.get(destino.getCodigo()).getAsDouble();
        return cantidad * tasa;
    }
}















