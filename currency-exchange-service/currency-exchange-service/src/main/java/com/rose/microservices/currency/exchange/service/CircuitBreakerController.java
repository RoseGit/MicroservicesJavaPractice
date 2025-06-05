package com.rose.microservices.currency.exchange.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//El nombre debe hacer match con el archivo .properties de la configuracion, puedo tener una configuracion de intentos por servicio
	@Retry(name="sample-api", fallbackMethod = "hardCodedResponse")
	public String simpleApi() {
		logger.info("Sample call received");
		//provocandi un fallo y validando el uso de @Retry
		var restTemplate = new RestTemplate().getForEntity("http://localhost:8080", String.class);
		return restTemplate.getBody();
	}
	
	//Debe aceptar un parametro de tipo Throwable
	//Puedo manejar un fallbackMethod diferente por cada tipo de exception 
	//Esto se ejecuta hasta que se terminan todos los reintentos de llamada al servicio 
	public String hardCodedResponse(Exception ex) {
		return "Response hardcoded";
	}
}
