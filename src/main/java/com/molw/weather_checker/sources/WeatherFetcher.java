package com.molw.weather_checker.sources;

import com.molw.weather_checker.data.WeatherReading;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WeatherFetcher {

	private final String openweather_key = System.getenv("openweather_api_key");
	private final String APIURL = "https://api.openweathermap.org/data/2.5/weather?exclude=minutely,hourly,daily,alerts&units=imperial&appid=" + openweather_key;

	public WeatherReading getAPlaceReading(String latLongURLString){

		//Finalize the webclient by adding the lat and long string to the end.
		WebClient webClient = WebClient.builder()
				.baseUrl(APIURL + latLongURLString)
				.build();

		//Create the weatherreading object we want to populate
		WeatherReading weatherReading = new WeatherReading();

		//Get the weather reading
		Mono<WeatherReading> monoResponse = webClient.get().accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(WeatherReading.class);

		//Get the reading out of the Stream and into a "usable" object
		weatherReading = monoResponse.block();
		return weatherReading;

	}


	public WeatherReading getOneTestPlace(){

		WebClient webClient = WebClient.builder()
				.baseUrl(APIURL + "&lat=36.962421&lon=-122.023301")
				.build();

		//WeatherReading response;
		System.out.println("The URL is  = " + APIURL);
		WeatherReading weatherReading = new WeatherReading();
		Mono<WeatherReading> monoResponse = webClient.get().accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(WeatherReading.class);

		weatherReading = monoResponse.block();
		return weatherReading;

	}

   	 
}
