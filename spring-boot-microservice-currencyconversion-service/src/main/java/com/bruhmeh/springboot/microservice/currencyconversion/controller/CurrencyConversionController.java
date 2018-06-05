package com.bruhmeh.springboot.microservice.currencyconversion.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bruhmeh.springboot.microservice.currencyconversion.dto.CurrencyConversionBean;
import com.bruhmeh.springboot.microservice.currencyconversion.proxy.CurrencyExchangeServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyConversionController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

//	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
//	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
//			@PathVariable BigDecimal quantity) {
//		
//		Map<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("from", from);
//		uriVariables.put("to", to);
//		
//		CurrencyConversionBean forexResponse = new RestTemplate().getForEntity(
//				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables).getBody();
//		
//		forexResponse.setQuantity(quantity);
//		
//		return CurrencyConversionBean.generateCurrencyConversionBeanFromForex(forexResponse);
//	}
	
	  @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	  @HystrixCommand(fallbackMethod="getDefaultConvertCurrency")
	  public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
	      @PathVariable BigDecimal quantity) {

	    CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
	    
	    response.setQuantity(quantity);

	    logger.info("{}", response);

	    return CurrencyConversionBean.generateCurrencyConversionBeanFromForex(response);
	  }
	  
	  public CurrencyConversionBean getDefaultConvertCurrency( String from,  String to,
		       BigDecimal quantity) {


		    return new CurrencyConversionBean(null, from, to, null, quantity, null, 0);
		  }
}
