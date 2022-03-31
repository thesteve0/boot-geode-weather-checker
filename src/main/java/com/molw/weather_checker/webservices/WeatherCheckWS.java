package com.molw.weather_checker.webservices;


import com.molw.weather_checker.data.WeatherReading;
import com.molw.weather_checker.data.WeatherReadings;
import com.molw.weather_checker.sources.WeatherFetcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherCheckWS {

	//TODO this should get from the cache
	@GetMapping("/")
	public WeatherReadings checkTheWeather(){
		WeatherReadings wr = new WeatherReadings();
		return wr;
	}

	@GetMapping("/test")
	public WeatherReading checkOneWeather(){
		WeatherFetcher wf = new WeatherFetcher();
		//WeatherReading response = wf.getOnePlace();
		WeatherReading response = wf.getOneTestPlace();

		return response;
	}

}
