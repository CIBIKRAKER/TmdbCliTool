package com.project.API;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    public static String getApiKey(){
        try{
            properties.load(new FileInputStream("config.properties"));
        }catch(IOException e){
            throw new RuntimeException("Could not load config.properties");
        }
        return properties.getProperty("api.key");
    }
}