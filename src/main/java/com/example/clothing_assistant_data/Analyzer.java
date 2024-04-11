package com.example.clothing_assistant_data;

import com.example.I18nHandler;
import com.example.Keys;

import java.util.List;
import java.util.StringJoiner;

class Analyzer {

    private static AnalysisObject analysis(List<Double> data, int beginningHour, int endingHour){
        double min = Double.POSITIVE_INFINITY, max = Double.NEGATIVE_INFINITY, avg = 0;
        int minHour = 0, maxHour = 0;
        for (int i = beginningHour; i < endingHour; i++) {
            double el = data.get(i);
            if (el < min){
                min = el;
                minHour = i;
            }
            if (el > max){
                max = el;
                maxHour = i;
            }
            avg += el;
        }
        avg /= endingHour - beginningHour;

        return new AnalysisObject(min, max, avg, minHour, maxHour);
    }
    public static String run(WeatherInfo info, int beginningHour, int endingHour){
        StringJoiner weatherDesc = new StringJoiner(" ");
        StringJoiner outfitDesc = new StringJoiner(" ");
        AnalysisObject temperature = analysis(info.getTemperatureArr(), beginningHour, endingHour);
        AnalysisObject precipitation = analysis(info.getPrecipitationArr(), beginningHour, endingHour);
        AnalysisObject rain = analysis(info.getRainArr(), beginningHour, endingHour);
        AnalysisObject showers = analysis(info.getShowersArr(), beginningHour, endingHour);
        AnalysisObject snow = analysis(info.getSnowfallArr(), beginningHour, endingHour);


        // overall
        weatherDesc.add(I18nHandler.get(Keys.overall));
        if (temperature.getAvg() > 25){
            weatherDesc.add(I18nHandler.get(Keys.strongly));
            weatherDesc.add(I18nHandler.get(Keys.hot).concat("."));
            outfitDesc.add(I18nHandler.get(Keys.summerOutfit));
        }
        else if (temperature.getAvg() > 15){
            weatherDesc.add(I18nHandler.get(Keys.fairly));
            weatherDesc.add(I18nHandler.get(Keys.warm).concat("."));
            outfitDesc.add(I18nHandler.get(Keys.summerOutfit));
        }
        else if (temperature.getAvg() > 5){
            weatherDesc.add(I18nHandler.get(Keys.fairly));
            weatherDesc.add(I18nHandler.get(Keys.chill).concat("."));
            outfitDesc.add(I18nHandler.get(Keys.middleOutfit));

        }
        else if (temperature.getAvg() > 0){
            weatherDesc.add(I18nHandler.get(Keys.fairly));
            weatherDesc.add(I18nHandler.get(Keys.cold).concat("."));
            outfitDesc.add(I18nHandler.get(Keys.middleOutfit));
        }
        else if (temperature.getAvg() <= 0){
            weatherDesc.add(I18nHandler.get(Keys.strongly));
            weatherDesc.add(I18nHandler.get(Keys.cold).concat("."));
            outfitDesc.add(I18nHandler.get(Keys.winterOutfit));
        }

        //temperature
        weatherDesc.add(I18nHandler.get(Keys.temperature)).add(String.format("%.2f", temperature.getAvg()));
        weatherDesc.add(I18nHandler.get(Keys.temperatureMin)).add(String.valueOf(temperature.getMin()));
        weatherDesc.add(I18nHandler.get(Keys.temperatureHour)).add(String.valueOf(temperature.getMinHour()));
        weatherDesc.add(I18nHandler.get(Keys.temperatureMax)).add(String.valueOf(temperature.getMax()));
        weatherDesc.add(I18nHandler.get(Keys.temperatureHour)).add(String.valueOf(temperature.getMaxHour()).concat("."));

        //precipitation
        if (precipitation.getAvg() < 1){
            weatherDesc.add(I18nHandler.get(Keys.noPrecipitation));
        }
        else if (precipitation.getAvg() >= 1) {
            if (rain.getAvg() > 1 || showers.getAvg() > 1){
                weatherDesc.add(I18nHandler.get(Keys.rainy));
                outfitDesc.add(I18nHandler.get(Keys.rainCoat));
            }
            else if (snow.getAvg() > 1){
                weatherDesc.add(I18nHandler.get(Keys.snowy));
                outfitDesc.add(I18nHandler.get(Keys.winterCoat));
            }

        }
        weatherDesc.add(outfitDesc.toString());
        return weatherDesc.toString();
    }
    private static double FahrToC(double Fahr){
        return 5.0/9 * (Fahr - 32);
    }
    private static double CToFahr(double C){
        return 9.0/5 * C + 32;
    }
}
