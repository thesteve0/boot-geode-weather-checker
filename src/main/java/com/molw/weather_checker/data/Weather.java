package com.molw.weather_checker.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.cache.annotation.Cacheable;

@Cacheable("quotes")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
	private String place = "";
	//TODO add other weather data we want to track
	private Double temp = 0.0;
	private Integer humidity = 0;
	private Double	uvi = 0.0;
	private Integer pressure = 0;
	private Double wind_speed = 0.0;

	public Weather() {
	}

	public Weather(String place, Double temp, Integer humidity, Double uvi, Integer pressure, Double wind_speed) {
		this.place = place;
		this.temp = temp;
		this.humidity = humidity;
		this.uvi = uvi;
		this.pressure = pressure;
		this.wind_speed = wind_speed;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
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

	public Double getUvi() {
		return uvi;
	}

	public void setUvi(Double uvi) {
		this.uvi = uvi;
	}

	public Integer getPressure() {
		return pressure;
	}

	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public Double getWind_speed() {
		return wind_speed;
	}

	public void setWind_speed(Double wind_speed) {
		this.wind_speed = wind_speed;
	}

	@Override
	public String toString() {
		return "Quote{" +
				"symbol='" + place + '\'' +
				", price=" + temp +
				'}';
	}
}
