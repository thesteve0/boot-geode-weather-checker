package com.molw.weather_checker.data;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class WeatherReadings {

	private ArrayList<Weather> weathers = new ArrayList<Weather>();
	private final ZonedDateTime checkTime = ZonedDateTime.now();

	public WeatherReadings(ArrayList<Weather> weathers) {
		this.weathers = weathers;
	}

	public WeatherReadings() {}

	public ArrayList<Weather> getQuotes() {
		return weathers;
	}

	public void setQuotes(ArrayList<Weather> weathers) {
		this.weathers = weathers;
	}

	public ZonedDateTime getCheckTime() {
		return checkTime;
	}

	//TODO fix this
	@Override
	public String toString() {
		return "DigitalCurrencies{" +
				"quotes=" + weathers.toString() +
				", checkTime=" + checkTime.toString() +
				'}';
	}
}
