package com.molw.digicurrency_checker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootscraperApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootscraperApplication.class, args);
	}

	//We also have a scheduled method in a class (DigiCurrencyChecker) that is set to run if we don't start in dev mode
}
