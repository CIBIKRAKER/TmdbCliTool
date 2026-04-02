package com.project.API;

import com.project.API.Config;
import com.sun.net.httpserver.Request;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


import static com.sun.management.HotSpotDiagnosticMXBean.ThreadDumpFormat.JSON;

public class TmdbAPI {
    private static final String API_URL = "https://api.themoviedb.org/3";

    public List<Object> fetchPopularMovies(String urlParameter) throws IOException, InterruptedException {
        List<Object> list = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + String.format("/movie/%s?api_key=%s",urlParameter,Config.getApiKey())))
                .GET()
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonObject = new JSONObject(response.body());
        JSONArray results = jsonObject.getJSONArray("results");

        for(Object o : results) {
            JSONObject movie = (JSONObject) o;
            String title = movie.getString("title");
            Double rating = movie.getDouble("vote_average");
            list.add(title + " | " + rating);
        }

        return list;
    }


}