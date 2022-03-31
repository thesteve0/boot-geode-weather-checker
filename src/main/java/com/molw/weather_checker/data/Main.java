package com.molw.weather_checker.data;

public class Main {


    private Double temp = 0.0;
    private Integer humidity = 0;
    private Integer pressure = 0;

    public Main() {
    }

    public Main(Double temp, Integer humidity, Integer pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }
}
