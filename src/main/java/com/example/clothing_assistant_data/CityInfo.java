package com.example.clothing_assistant_data;

import org.json.JSONArray;
import org.json.JSONObject;

public class CityInfo {
    Double lat, lon;
    String name;

    public CityInfo(String data) {
        JSONObject dataJSON = new JSONArray(data).getJSONObject(0);

        this.lat = dataJSON.getDouble("lat");
        this.lon = dataJSON.getDouble("lon");
        this.name = dataJSON.getString("name");


}
    @Override
    public String toString() {
        return "CityInfo{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", name='" + name + '\'' +
                '}';
    }
}


