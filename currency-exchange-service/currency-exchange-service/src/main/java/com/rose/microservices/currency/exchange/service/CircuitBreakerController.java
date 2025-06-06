package com.rose.microservices.currency.exchange.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//El nombre debe hacer match con el archivo .properties de la configuracion, puedo tener una configuracion de intentos por servicio
	//@Retry(name="sample-api", fallbackMethod = "hardCodedResponse")
	//Esta anotacion permite enviar la solicitud de hardCodedResponse en automatico si detecta que el servicio falla multiples veces
	//@CircuitBreaker(name="default", fallbackMethod = "hardCodedResponse")
	//Limita el numero de request por segundo
	@RateLimiter(name="default")
	public String simpleApi() {
		logger.info("Sample call received");
		//provocandi un fallo y validando el uso de @Retry
		/*var restTemplate = new RestTemplate().getForEntity("http://localhost:8080", String.class);
		return restTemplate.getBody();*/
		return "Sample rate limiter";
	}
	
	//Debe aceptar un parametro de tipo Throwable
	//Puedo manejar un fallbackMethod diferente por cada tipo de exception 
	//Esto se ejecuta hasta que se terminan todos los reintentos de llamada al servicio 
	public String hardCodedResponse(Exception ex) {
		return "Response hardcoded";
	}
}
