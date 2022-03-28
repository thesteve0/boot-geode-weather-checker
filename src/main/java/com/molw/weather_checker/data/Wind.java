package com.molw.weather_checker.data;

public class Wind {

    private Double speed = 0.0;
    private Double gust = 0.0;
    private Integer deg = 0;

    public Wind() {
    }

    public Wind(Double speed, Double gust, Integer deg) {
        this.speed = speed;
        this.gust = gust;
        this.deg = deg;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getGust() {
        return gust;
    }

    public void setGust(Double gust) {
        this.gust = gust;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }
}
