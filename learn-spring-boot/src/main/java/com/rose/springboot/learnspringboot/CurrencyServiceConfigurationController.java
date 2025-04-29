package com.rose.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Shows the usage for obtaining information from the application.properties properties file.
 */
@RestController
public class CurrencyServiceConfigurationController {

	@Autowired
	private CurrencyServiceConfiguration configuration;
	
	/**
	 * simple service that retrieve properties information
	 * @return See {@link CurrencyServiceConfiguration} */
	@RequestMapping("currency-configuration")
	public CurrencyServiceConfiguration retrieveConfiguration() {
		return configuration;
	}
}
