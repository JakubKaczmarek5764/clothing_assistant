package com.example.clothing_assistant_view;

import com.example.I18nHandler;
import com.example.Keys;
import com.example.clothing_assistant_data.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {

    public TextField cityTextField;
    public Text analysisOutput;
    public TextField beginningHourTextField;
    public TextField endingHourTextField;
    public Button analyzeButton;

    @FXML
    public void initialize(){
        cityTextField.setPromptText(I18nHandler.get(Keys.cityTextField));
        beginningHourTextField.setPromptText(I18nHandler.get(Keys.beginningHourTextField));
        endingHourTextField.setPromptText(I18nHandler.get(Keys.endingHourTextField));
        analyzeButton.setText(I18nHandler.get(Keys.analyzeButton));
    }
    @FXML
    public void analyze() {
        DataAPI Data = DataAPI.createInstance(); // TODO: checking parsed values
        String cityName = cityTextField.getText();
        int beginningHour = Integer.parseInt(beginningHourTextField.getText());
        int endingHour = Integer.parseInt(endingHourTextField.getText());
        String analysis = Data.getAnalysis(cityName, beginningHour, endingHour);
        analysisOutput.setText(analysis);
    }
}