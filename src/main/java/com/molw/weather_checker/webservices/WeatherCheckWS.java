package com.molw.weather_checker.webservices;


import com.molw.weather_checker.data.WeatherReading;
import com.molw.weather_checker.sources.WeatherFetcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherCheckWS {

	//TODO this should get from the cache
	@GetMapping("/")
	public String checkTheWeather(){
		return "worked";
	}

	@GetMapping("/test")
	public WeatherReading checkOneWeather(){
		WeatherFetcher wf = new WeatherFetcher();
		//WeatherReading response = wf.getOnePlace();
		WeatherReading response = wf.getOneTestPlace();

		return response;
	}

}
