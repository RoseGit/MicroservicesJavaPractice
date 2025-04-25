package com.rose.rest.webservices.restful.web.services.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/***
 * Simple rest services
 */
@RestController
public class HelloWorldController {

	private MessageSource messageSource;
	
	/***
	 * Default constructor
	 * @param messageSource See {@link MessageSource}
	 */
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	/**
	 * Generate Hello world service
	 * @return
	 */
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	/**
	 * generate hello world using java bean 
	 * @return
	 */
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World bean");
	}
	
	/**
	 * Hello world service wih a parameter in the endpoint
	 * @param name Name of parameter variable
	 * @return
	 */
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world %s", name));
	}
	
	/***
	 * Shows how to internationalizeed a message
	 * @return The same message, but in a different language.
	 */
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		/*
		 * How to internationalizeed this message ?
		 * 1. Definir en el archivo este mensaje (messages.properties)
		 * 2. Escribir el codigo para leer el mensaje correcto  
		 * locale lo tomames de los header de la peticion 
		 * */
		
		//Obteniendo el locale desde la petición, si no se especifica toma por default el del sistema
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default message", locale );
		//return "Hello World";
	}
}
