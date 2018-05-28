package com.bruhmeh.springboot.microservice.forex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruhmeh.springboot.microservice.forex.model.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);
}
