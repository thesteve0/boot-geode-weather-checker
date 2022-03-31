package com.molw.weather_checker.data;

import java.time.ZonedDateTime;
import java.util.ArrayList;


//TODO probably remove this since we are not going to aggregate multiple readings into a single place
// We will be putting them into the cache as we get them
public class WeatherReadings {

	private ArrayList<WeatherReading> weatherReadings = new ArrayList<WeatherReading>();
	private final ZonedDateTime checkTime = ZonedDateTime.now();

	public WeatherReadings(ArrayList<WeatherReading> weatherReadings) {
		this.weatherReadings = weatherReadings;
	}

	public WeatherReadings() {}

	public ArrayList<WeatherReading> getQuotes() {
		return weatherReadings;
	}

	public void setQuotes(ArrayList<WeatherReading> weatherReadings) {
		this.weatherReadings = weatherReadings;
	}

	public ZonedDateTime getCheckTime() {
		return checkTime;
	}

	//TODO fix this
	@Override
	public String toString() {
		return "DigitalCurrencies{" +
				"quotes=" + weatherReadings.toString() +
				", checkTime=" + checkTime.toString() +
				'}';
	}
}
