package com.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from ,@PathVariable String to) {
		 ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		 exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		 logger.info("{}",exchangeValue);
		 return exchangeValue;
	}
	
	
	@GetMapping("/currency-exchange/byId/{id}")
	public ExchangeValue retriveExchangeValueFromId(@PathVariable Long id) {
		ExchangeValue exchgeValue =null;
		 Optional<ExchangeValue> findById = repository.findById(id);
		 if(findById.isPresent()) {
			 findById.ifPresent(System.out::println);
			 exchgeValue = findById.get();
		 }
		return exchgeValue;
	}
	
	
	@GetMapping("/greeting")
    public String greeting() {
		
		return "Hello World";
	}
}
