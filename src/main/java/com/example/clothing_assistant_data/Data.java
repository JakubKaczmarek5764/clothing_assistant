package com.example.clothing_assistant_data;

import com.example.I18nHandler;

import java.io.IOException;

class Data implements DataAPI {
    @Override
    public String getAnalysis(String cityName, int beginningHour, int endingHour) {
        // get JSON object from geocoding API
        String analysis;
        String cityJSON = null;
        try {
            cityJSON = APIConnector.getCityInfo(cityName);
        } catch (IOException e) {
            analysis = I18nHandler.get("geocodingFail");
            return analysis;
        }
        // get relevant data from JSON
        CityInfo city = new CityInfo(cityJSON);
        // get JSON object from weather API
        String weatherJSON = null;
        try {
            weatherJSON = APIConnector.getWeatherInfo(city.lat, city.lon);
        } catch (IOException e) {
            analysis = I18nHandler.get("weatherAPIFail");
            return analysis;
        }
        // get relevant data from JSON
        WeatherInfo weather = new WeatherInfo(weatherJSON);
        // analyze data
        analysis = Analyzer.run(weather, beginningHour, endingHour);
        return analysis;
    }
}
