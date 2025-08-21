package dev.aymee.dao;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class ApiMoviesDAO implements InterfaceApiMoviesDAO{

     private String url;

     public ApiMoviesDAO() {
        this.url = "https://imdb.iamidiotareyoutoo.com/search?tt=";
    }


     @Override
    public String getMovie(String imdbId) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + imdbId))
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            CompletableFuture<HttpResponse<String>> response = HttpClient.newBuilder()
                    .build()
                    .sendAsync(request, BodyHandlers.ofString());
            return response.get().body();
        } catch (Exception e) {
            return e.getMessage();
        }
    
}}
