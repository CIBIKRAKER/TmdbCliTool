package com.project;

import com.project.API.TmdbAPI;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


public class Main {
    public static void main(String[] args) {
        try {
            Options options = new Options();
            Option typeOption = new Option(null, "type", true, "Movie type: popular, top, upcoming, playing");
            options.addOption(typeOption);

            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            TmdbAPI api = new TmdbAPI();
            List<String> movies = api.getMoviesByType(cmd.getOptionValue("type", "popular"));

            for (String movie : movies) {
                System.out.println(movie);
            }
        } catch (ParseException e) {
            System.out.println("Invalid arguments: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}