package com.example.clothing_assistant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        CityInfo city = new CityInfo(APIConnector.getCityInfo("Zdunska Wola"));
        WeatherInfo info = new WeatherInfo(APIConnector.getWeatherInfo(city.lat, city.lon));
        System.out.println(Analyzer.run(info));

        System.out.println(city);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}