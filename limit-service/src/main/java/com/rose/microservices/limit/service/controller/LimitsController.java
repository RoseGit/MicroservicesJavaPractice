package com.rose.microservices.limit.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rose.microservices.limit.service.bean.Limits;
import com.rose.microservices.limit.service.configuration.Configuration;

/**
 * Exposes services to observe limit values.
 */
@RestController
public class LimitsController {

	@Autowired
	private Configuration configuration;
	
	/**
	 * Obtains information about the configured limits
	 * @return See {@link Limits}*/
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
		//return new Limits(1, 1000);
	}
}
