package com.molw.weather_checker.sources;

/*

Using this API
https://p.nomics.com/cryptocurrency-bitcoin-api



 */

import com.molw.weather_checker.data.WeatherReadings;
import com.molw.weather_checker.data.Weather;
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
					{"name", "Santa Cruz, CA"},
					{"ETC", "Ethereum"},
					{"DOGE", "Dogecoin"},
					{"RVN", "Ravencoin"},
					{"XCH", "Chia"}
			}
		).collect(Collectors.toMap(data -> data[0], data -> data[1]));

	//TODO update key information here
	private final String openweather_key = System.getenv("openweather_api_key");
	private final String url = "https://api.openweathermap.org/data/2.5/weather?exclude=minutely,hourly,daily,alerts&units=imperial&appid=" + openweather_key + "&lat=36.962421&lon=-122.023301";
	private WebClient webClient = WebClient.builder()
			.baseUrl(url)
			.build();

	//TODO given the API I think this will have to be a loop of calls rather than just one call
	public WeatherReadings getWeather(){
		WeatherReadings currentWeathers = new WeatherReadings();
		Mono<Weather> response = webClient.get().accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<Weather>() {});

		// currentPrices.setQuotes( (ArrayList<Weather>) response.block());


		return currentWeathers;
		
	}

	public Weather getOnePlace(){

		Weather weather = new Weather();
		Mono<Weather> response = webClient.get().accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<Weather>() {});

		return weather;

	}

   	 
}
