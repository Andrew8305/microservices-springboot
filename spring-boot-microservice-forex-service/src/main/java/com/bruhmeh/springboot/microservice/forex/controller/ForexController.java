package com.bruhmeh.springboot.microservice.forex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bruhmeh.springboot.microservice.forex.model.ExchangeValue;
import com.bruhmeh.springboot.microservice.forex.repository.ExchangeValueRepository;

@RestController
public class ForexController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangedValue = repository.findByFromAndTo(from, to);
		exchangedValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		return exchangedValue;
	}
}
