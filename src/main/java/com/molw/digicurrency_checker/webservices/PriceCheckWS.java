package com.molw.digicurrency_checker.webservices;


import com.molw.digicurrency_checker.data.DigitalCurrencies;
import com.molw.digicurrency_checker.data.PriceCheck;
import com.molw.digicurrency_checker.sources.DellCameraScraper;
import com.molw.digicurrency_checker.sources.DigiCurrencyFetcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceCheckWS {

	@GetMapping("/")
	public PriceCheck checkThePrice(){
		double price = DellCameraScraper.scrapeSite();
		PriceCheck pc = new PriceCheck(price);
		return pc;
	}

	@GetMapping("/currency")
	public DigitalCurrencies getDigitaCurrencyQuotes(){
		  DigiCurrencyFetcher dcFetcher = new DigiCurrencyFetcher();
		  return dcFetcher.getQuotes();
		  		
	}

	@GetMapping("/health")
	public String amIHealthy(){
		return "yes";
	}

	@GetMapping("/ready")
	public String amIReady(){
		//TODO once we plug in the cache we need to make sure we can actually access the
		// cache object before we are ready
		return "yes";
	}


}
