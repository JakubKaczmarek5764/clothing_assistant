package com.example.clothing_assistant_view;

import com.example.clothing_assistant_data.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class HelloController {

    public TextField cityTextField;
    public Text analysisOutput;

    @FXML
    public void analyze() {
        DataAPI Data = DataAPI.createInstance();
        String cityName = cityTextField.getText();
        String analysis = Data.getAnalysis(cityName);
        analysisOutput.setText(analysis);
    }
}