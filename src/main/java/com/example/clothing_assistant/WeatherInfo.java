package com.example.clothing_assistant;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherInfo {

    public List<Double> getTemperatureArr() {
        return List.copyOf(temperatureArr);
    }

    public List<Double> getHumidityArr() {
        return List.copyOf(humidityArr);
    }

    public List<Double> getRainArr() {
        return List.copyOf(rainArr);
    }

    public List<Double> getShowersArr() {
        return List.copyOf(showersArr);
    }

    public List<Double> getSnowfallArr() {
        return List.copyOf(snowfallArr);
    }

    public List<Double> getPressureArr() {
        return List.copyOf(pressureArr);
    }

    public List<Double> getVisibilityArr() {
        return List.copyOf(visibilityArr);
    }

    public List<Double> getWindArr() {
        return List.copyOf(windArr);
    }
    public List<Double> getPrecipitationArr() {
        return List.copyOf(this.precipitationArr);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    private List<Double> precipitationArr, temperatureArr, humidityArr, rainArr, showersArr, snowfallArr, pressureArr, visibilityArr, windArr;
    private double latitude, longtitude;

    public WeatherInfo(String data) {


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
         this.precipitationArr = JSONArrayToList(dataJSON.getJSONArray("precipitation"));

    }
    private List<Double> JSONArrayToList(JSONArray arr){
        List<Double> output = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++){
            output.add(Double.parseDouble(arr.get(i).toString()));
        }
        return output;
    }



}
