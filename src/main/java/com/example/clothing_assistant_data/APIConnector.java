package com.example.clothing_assistant_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


class APIConnector {
    private static BufferedReader getResponse(String url) throws IOException {
        URLConnection con = new URL(url).openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        return in;
    }
    public static String getWeatherInfo(double lat, double lon) throws IOException {

        String url = String.format("https://api.open-meteo.com/v1/forecast?latitude=%.2f&longitude=%.2f&hourly=temperature_2m,relative_humidity_2m,precipitation,rain,showers,snowfall,surface_pressure,visibility,wind_speed_10m&forecast_days=1",
                lat, lon);


        String response = getResponse(url).readLine();
    return response;
    }
    public static String getCityInfo(String cityName) throws IOException {
        String url = "https://nominatim.openstreetmap.org/search?q="+
                cityName.replaceAll(" ", "%20")+
                "&format=json";
        String response = getResponse(url).readLine();
        return response;
    }
}
