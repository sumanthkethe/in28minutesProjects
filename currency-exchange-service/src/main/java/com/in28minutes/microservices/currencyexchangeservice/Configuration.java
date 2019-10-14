package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class Configuration {

	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
