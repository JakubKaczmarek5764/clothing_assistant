package com.example.clothing_assistant;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherInfo {
    public List<Object> getTemperatureArr() {
        return List.copyOf(temperatureArr);
    }

    public List<Object> getHumidityArr() {
        return List.copyOf(humidityArr);
    }

    public List<Object> getRainArr() {
        return List.copyOf(rainArr);
    }

    public List<Object> getShowersArr() {
        return List.copyOf(showersArr);
    }

    public List<Object> getSnowfallArr() {
        return List.copyOf(snowfallArr);
    }

    public List<Object> getPressureArr() {
        return List.copyOf(pressureArr);
    }

    public List<Object> getVisibilityArr() {
        return List.copyOf(visibilityArr);
    }

    public List<Object> getWindArr() {
        return List.copyOf(windArr);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    private List<Double> temperatureArr, humidityArr, rainArr, showersArr, snowfallArr, pressureArr, visibilityArr, windArr;
    private double latitude, longtitude;

    public WeatherInfo(String data) {

        data = """
                {
                  "latitude": 52.52,
                  "longitude": 13.419998,
                  "generationtime_ms": 0.0879764556884766,
                  "utc_offset_seconds": 0,
                  "timezone": "GMT",
                  "timezone_abbreviation": "GMT",
                  "elevation": 38,
                  "hourly_units": {
                    "time": "iso8601",
                    "temperature_2m": "°C",
                    "relative_humidity_2m": "%",
                    "precipitation": "mm",
                    "rain": "mm",
                    "showers": "mm",
                    "snowfall": "cm",
                    "surface_pressure": "hPa",
                    "visibility": "m",
                    "wind_speed_10m": "km/h"
                  },
                  "hourly": {
                    "time": [
                      "2024-04-06T00:00",
                      "2024-04-06T01:00",
                      "2024-04-06T02:00",
                      "2024-04-06T03:00",
                      "2024-04-06T04:00",
                      "2024-04-06T05:00",
                      "2024-04-06T06:00",
                      "2024-04-06T07:00",
                      "2024-04-06T08:00",
                      "2024-04-06T09:00",
                      "2024-04-06T10:00",
                      "2024-04-06T11:00",
                      "2024-04-06T12:00",
                      "2024-04-06T13:00",
                      "2024-04-06T14:00",
                      "2024-04-06T15:00",
                      "2024-04-06T16:00",
                      "2024-04-06T17:00",
                      "2024-04-06T18:00",
                      "2024-04-06T19:00",
                      "2024-04-06T20:00",
                      "2024-04-06T21:00",
                      "2024-04-06T22:00",
                      "2024-04-06T23:00"
                    ],
                    "temperature_2m": [13, 12.8, 12.4, 12.1, 12, 11.8, 12.2, 13.6, 15.2, 17.9, 19.5, 20.8, 21.2, 22.3, 22.4, 22.5, 22.1, 21.2, 19.7, 18.4, 17.4, 16.6, 15.9, 15.4],
                    "relative_humidity_2m": [87, 87, 88, 91, 91, 90, 87, 81, 75, 67, 58, 53, 54, 50, 52, 51, 53, 60, 69, 73, 75, 77, 79, 78],
                    "precipitation": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    "rain": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    "showers": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    "snowfall": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                    "surface_pressure": [1008.2, 1009, 1010, 1010.3, 1010.1, 1009.9, 1010.7, 1010.9, 1011, 1011.3, 1011.2, 1010.8, 1010.7, 1010.5, 1010.2, 1009.8, 1009.4, 1009.2, 1009.7, 1010.1, 1010.3, 1010.3, 1010.2, 1009.9],
                    "visibility": [24140, 24140, 24140, 24140, 24140, 24140, 24140, 24140, 24140, 20720, 24140, 24140, 24140, 24140, 24140, 24140, 24140, 24140, 24140, 24140, 24140, 24140, 24140, 24140],
                    "wind_speed_10m": [5.6, 8.4, 7.2, 5.5, 6.9, 6.9, 6, 6, 8.1, 9.1, 11.8, 9.6, 10.5, 10.9, 9.5, 9.4, 9.8, 8.2, 7.7, 10.2, 9.5, 9.2, 8.4, 7.8]
                  }
                }
                """;
         JSONObject dataJSON = new JSONObject(data);
         this.latitude = dataJSON.getDouble("latitude");
         this.longtitude = dataJSON.getDouble("longitude");
         dataJSON = dataJSON.getJSONObject("hourly");
         this.temperatureArr = JSONArrayToList(dataJSON.getJSONArray("temperature_2m"));
         this.humidityArr = JSONArrayToList(dataJSON.getJSONArray("relative_humidity_2m"));
         this.rainArr = JSONArrayToList(dataJSON.getJSONArray("rain"));
         this.showersArr = JSONArrayToList(dataJSON.getJSONArray("showers"));
         this.snowfallArr = JSONArrayToList(dataJSON.getJSONArray("snowfall"));
         this.pressureArr = JSONArrayToList(dataJSON.getJSONArray("surface_pressure"));
         this.visibilityArr = JSONArrayToList(dataJSON.getJSONArray("visibility"));
         this.windArr = JSONArrayToList(dataJSON.getJSONArray("wind_speed_10m"));
    }
    private List<Double> JSONArrayToList(JSONArray arr){
        List<Double> output = new ArrayList<>(arr.length());
        for (int i = 0; i < arr.length(); i++){
            output.add(Double.parseDouble(arr.get(i).toString()));
        }
        return output;
    }
    private AnalysisObject analysis(List<Double> data){
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE, avg = 0;
        int min_hour = 0, max_hour = 0;
        for (int i = 0; i < data.size(); i++) {
            double el = data.get(i);
            if (el < min){
                min = el;
                min_hour = i;
            }
            if (el > max){
                max = el;
                max_hour = i;
            }
            avg += el;
        }
        avg /= data.size();
        return new AnalysisObject(min, max, avg, min_hour, max_hour);
    }
    public AnalysisObject temperatureAnalysis(){
        return analysis(this.temperatureArr);
    }
    public AnalysisObject humidityAnalysis(){
        return analysis(this.humidityArr);
    }
    public AnalysisObject rainAnalysis(){
        return analysis(this.rainArr);
    }
    public AnalysisObject showersAnalysis(){
        return analysis(this.showersArr);
    }public AnalysisObject snowfallAnalysis(){
        return analysis(this.snowfallArr);
    }
    public AnalysisObject pressureAnalysis(){
        return analysis(this.pressureArr);
    }
    public AnalysisObject visibilityAnalysis(){
        return analysis(this.visibilityArr);
    }
    public AnalysisObject windAnalysis(){
        return analysis(this.windArr);
    }


}
