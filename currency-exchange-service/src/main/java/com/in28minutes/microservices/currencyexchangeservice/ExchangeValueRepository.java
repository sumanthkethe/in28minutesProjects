package com.in28minutes.microservices.currencyexchangeservice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from,String to);
	
	Optional<ExchangeValue> findById(Long id);
	

}
