package com.molw.weather_checker.sources;

/*

Using this API
https://p.nomics.com/cryptocurrency-bitcoin-api



 */

import com.molw.weather_checker.data.WeatherReadings;
import com.molw.weather_checker.data.WeatherReading;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WeatherFetcher {
	//Also need to add the currency to the url line below
	private static final HashMap<String, String> locations = (HashMap) Stream.of(new String[][]
			{
					{"Santa Cruz, CA", "&lat=36.962421&lon=-122.023301"},
					{"Madrid, ES", "Ethereum"},
					{"Sydney, AU", "Dogecoin"},
					{"Atlanta, GA", "Ravencoin"},
					{"Denver, CO", "Chia"},
					{"Austin, TX", "Chia"}
			}
		).collect(Collectors.toMap(data -> data[0], data -> data[1]));

	private final String openweather_key = System.getenv("openweather_api_key");
	private final String url = "https://api.openweathermap.org/data/2.5/weather?exclude=minutely,hourly,daily,alerts&units=imperial&appid=" + openweather_key;


	//TODO given the API I think this will have to be a loop of calls rather than just one call
	public WeatherReadings getWeather(){

		//TODO There is probably a good way to add a parameter on to the end of the base URL
		WebClient webClient = WebClient.builder()
				.baseUrl(url + locations.get("Santa Cruz, CA"))
				.build();

		//ok basically loop through the getOnePlace call below with changing the URL each time
		WeatherReadings currentWeathers = new WeatherReadings();
		Mono<WeatherReading> response = webClient.get().accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<WeatherReading>() {});

		// currentPrices.setQuotes( (ArrayList<WeatherReading>) response.block());


		return currentWeathers;
		
	}

	public WeatherReading getOnePlace(){

		WebClient webClient = WebClient.builder()
				.baseUrl(url + locations.get("Santa Cruz, CA"))
				.build();

		//WeatherReading response;
		System.out.println("The URL is  = " + url);
		WeatherReading weatherReading = new WeatherReading();
		Mono<WeatherReading> monoResponse = webClient.get().accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(WeatherReading.class);

		weatherReading = monoResponse.block();
		return weatherReading;

	}

   	 
}
