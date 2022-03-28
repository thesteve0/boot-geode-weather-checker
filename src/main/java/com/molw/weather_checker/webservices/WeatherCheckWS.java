package com.molw.weather_checker.webservices;


import com.molw.weather_checker.data.Weather;
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
	public Weather checkOneWeather(){
		WeatherFetcher wf = new WeatherFetcher();
		Weather response = wf.getOnePlace();

		return response;
	}

}