package com.example.clothing_assistant_data;

public interface DataAPI {
    String getAnalysis(String cityName, int beginningHour, int endingHour);
    static DataAPI createInstance(){
        return new Data();
    }
}
