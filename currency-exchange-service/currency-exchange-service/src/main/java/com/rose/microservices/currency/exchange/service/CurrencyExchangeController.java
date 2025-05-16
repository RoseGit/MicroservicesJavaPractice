package com.rose.microservices.currency.exchange.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private final CurrencyExchangeServiceApplication currencyExchangeServiceApplication;

	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repository;

    CurrencyExchangeController(CurrencyExchangeServiceApplication currencyExchangeServiceApplication) {
        this.currencyExchangeServiceApplication = currencyExchangeServiceApplication;
    }
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(
			@PathVariable String from, 
			@PathVariable String to) {
		
		//var currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
		var currencyExchange = repository.findByFromAndTo(from, to);
		if(currencyExchange == null) {
			throw new ResourceNotFoundException("Unable to find data for "+from +" to "+to, 1000);
		}
		
		/*Para generar otra instancia de la misma aplicacion en Run Configurations..
		 * Pasamos en los argumentos -Dserver.port=8001 esto sustituye el valor en el archivo properties de la propiedad local.server.port*/
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		
		
		
		return currencyExchange;
	}
	
}
