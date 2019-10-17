package com.in28minutes.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	
	@GetMapping("/limits")
	public LimitConfiguration retriveHardcodedLimitsFromConfiguration() {
		
		return new LimitConfiguration(1000,200);
		
	}
	
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod="fallBackRetriveConfiguration")
	public LimitConfiguration retriveConfiguration() {
		throw new RuntimeException("Not Available");
	}
	
	public LimitConfiguration fallBackRetriveConfiguration() {
		return new LimitConfiguration(9999, 9);
	}

	

	@GetMapping("/applicationPropertiesLimits")
	public LimitConfiguration retriveLimitsConfigurationFromApplicationProperties() {
		
		return new LimitConfiguration(configuration.getMaxium(),configuration.getMinium());
		
	}
	
	
}
