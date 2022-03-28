package com.molw.weather_checker.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.cache.annotation.Cacheable;

@Cacheable("quotes")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherReading {
	private String name;
	private Integer id;
	private Main main;
	private Wind win;

	public WeatherReading() {	}

	public WeatherReading(String name, Integer id, Main main, Wind win) {
		this.name = name;
		this.id = id;
		this.main = main;
		this.win = win;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWin() {
		return win;
	}

	public void setWin(Wind win) {
		this.win = win;
	}
}

