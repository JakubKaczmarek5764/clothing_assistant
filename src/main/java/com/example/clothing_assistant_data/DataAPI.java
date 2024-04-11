package com.example.clothing_assistant_data;

public interface DataAPI {
    public String getAnalysis(String cityName);
    static DataAPI createInstance(){
        return new Data();
    }
}
