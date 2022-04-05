package com.molw.weather_checker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherCheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherCheckerApplication.class, args);
	}

	//We also have a scheduled method in a class (WeatherCollector) that is set to run if we don't start in dev mode
}
