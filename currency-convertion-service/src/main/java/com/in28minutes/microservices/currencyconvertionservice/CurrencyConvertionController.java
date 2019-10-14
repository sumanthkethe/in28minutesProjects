package com.in28minutes.microservices.currencyconvertionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConvertionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	
	@GetMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertionBean convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		 ResponseEntity<CurrencyConvertionBean> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConvertionBean.class,uriVariables);
		 CurrencyConvertionBean convertionBean = forEntity.getBody();
		return new CurrencyConvertionBean(convertionBean.getId(), from, to, convertionBean.getConvertionMultiple(), quantity, quantity.multiply(convertionBean.getConvertionMultiple()), convertionBean.getPort());
	}
	
	@GetMapping(value = "/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertionBean convertCurrencyFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		 CurrencyConvertionBean retriveExchangeValue = currencyExchangeServiceProxy.retriveExchangeValue(from, to);
		
		 logger.info("{} ",retriveExchangeValue);
		 
		 return new CurrencyConvertionBean(retriveExchangeValue.getId(), from, to, retriveExchangeValue.getConvertionMultiple(), quantity, quantity.multiply(retriveExchangeValue.getConvertionMultiple()), retriveExchangeValue.getPort());
	}
	
	
	@GetMapping("/greetingfromus")
	public String getGreet() {
		 ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:9000/greeting", String.class);
		 return forEntity.getBody();
	}

}
