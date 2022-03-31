package com.molw.weather_checker.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.cache.annotation.Cacheable;

@Cacheable("quotes")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherReading {
	private String name;
	private Integer id;
	private Main main;
	private Wind wind;

	public WeatherReading() {	}

	public WeatherReading(String name, Integer id, Main main, Wind wind) {
		this.name = name;
		this.id = id;
		this.main = main;
		this.wind = wind;
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

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	@Override
	public String toString() {
		return "WeatherReading{" +
				"name='" + name + '\'' +
				", id=" + id +
				", main=" + main +
				", wind=" + wind +
				'}';
	}
}

