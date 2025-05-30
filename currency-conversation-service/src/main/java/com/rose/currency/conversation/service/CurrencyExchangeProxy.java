package com.rose.currency.conversation.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Configuracion cuando no esta en un naming-server como Eureka
//@FeignClient(name="currency-exchange", url="localhost:8000")

/*
 * Internamente se conecta al namig-server 
 * por la dependencia spring-cloud-starter-netflix-eureka-client
 * y la configuracion la toma del application.properties, no es necesario realizar nada mas 
 */
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(
			@PathVariable String from, 
			@PathVariable String to
			) ;
}
