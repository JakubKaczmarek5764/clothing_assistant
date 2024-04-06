package com.example.clothing_assistant;

public class AnalysisObject {
    private double min, max, avg;
    private int min_hour, max_hour;

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public int getMin_hour() {
        return min_hour;
    }

    public void setMin_hour(int min_hour) {
        this.min_hour = min_hour;
    }

    public int getMax_hour() {
        return max_hour;
    }

    public void setMax_hour(int max_hour) {
        this.max_hour = max_hour;
    }

    @Override
    public String toString() {
        return "AnalysisObject{" +
                "min=" + min +
                ", max=" + max +
                ", avg=" + avg +
                ", min_hour=" + min_hour +
                ", max_hour=" + max_hour +
                '}';
    }

    public AnalysisObject(double min, double max, double avg, int min_hour, int max_hour) {
        this.min = min;
        this.max = max;
        this.avg = avg;
        this.min_hour = min_hour;
        this.max_hour = max_hour;
    }

}
