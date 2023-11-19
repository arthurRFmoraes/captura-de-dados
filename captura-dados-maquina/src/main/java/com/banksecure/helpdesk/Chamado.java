package com.banksecure.helpdesk;

import com.banksecure.Componente;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Chamado {
    private Componente componente;
    private static String urlString = "https://banksecure.atlassian.net/rest/api/3";
    private static final String AUTH = System.getenv("JIRA_KEY");

    private void postarChamado(){
        try{

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString + ""))
                .GET()
                .header("Authorization", authHeader)
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = client.send(
                request, HttpResponse.BodyHandlers.ofString());
        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }

    }
}
