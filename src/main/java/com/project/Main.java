package com.project;

import com.project.API.TmdbAPI;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        Options options = new Options();
        options.addOption("type", true, "Movie type: popular, top, upcoming, playing");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options,args);

        TmdbAPI api = new TmdbAPI();
        List<String> movies = api.getMoviesByType(cmd.getOptionValue("type"));


        for(String movie : movies){
            System.out.println(movie);
        }
    }
}