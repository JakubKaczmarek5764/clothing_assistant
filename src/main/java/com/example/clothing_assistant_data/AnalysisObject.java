package com.example.clothing_assistant_data;

class AnalysisObject {
    private double min, max, avg;
    private int minHour, maxHour;


    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getAvg() {
        return avg;
    }

    public int getMinHour() {
        return minHour;
    }

    public int getMaxHour() {
        return maxHour;
    }

    @Override
    public String toString() {
        return "AnalysisObject{" +
                "min=" + min +
                ", max=" + max +
                ", avg=" + avg +
                ", min_hour=" + minHour +
                ", max_hour=" + maxHour +
                '}';
    }

    public AnalysisObject(double min, double max, double avg, int minHour, int maxHour) {
        this.min = min;
        this.max = max;
        this.avg = avg;
        this.minHour = minHour;
        this.maxHour = maxHour;
    }

}
