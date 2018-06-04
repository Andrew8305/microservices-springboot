package com.bruhmeh.springboot.microservice.currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.bruhmeh.springboot.microservice.currencyconversion.proxy")
@EnableDiscoveryClient
@EnableHystrix
public class SpringBootMicroserviceCurrencyconversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceCurrencyconversionServiceApplication.class, args);
	}
}
