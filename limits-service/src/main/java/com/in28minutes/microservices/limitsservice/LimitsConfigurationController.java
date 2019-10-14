package com.in28minutes.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	
	@GetMapping("/limits")
	public LimitConfiguration retriveHardcodedLimitsFromConfiguration() {
		
		return new LimitConfiguration(1000,200);
		
	}
	

	@GetMapping("/applicationPropertiesLimits")
	public LimitConfiguration retriveLimitsConfigurationFromApplicationProperties() {
		
		return new LimitConfiguration(configuration.getMaxium(),configuration.getMinium());
		
	}
	
	
}
