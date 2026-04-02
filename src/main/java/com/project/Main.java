package com.project;

import com.project.API.TmdbAPI;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        TmdbAPI tmdbAPI = new TmdbAPI();

        List<Object> movies = tmdbAPI.fetchPopularMovies();

        for(Object movie : movies) {
            System.out.println(movie);
        }

    }
}