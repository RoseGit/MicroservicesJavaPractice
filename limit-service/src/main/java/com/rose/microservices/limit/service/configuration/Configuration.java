package com.rose.microservices.limit.service.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Reads the properties corresponding to section 
 * limits-service in application.properties and maps them to corresponding class properties
 */
@Component
@ConfigurationProperties("limits-service")
public class Configuration {

	private int minimum;
	private int maximum;
	
	/**
	 * @return Get the minimum value since configuration  
	 */
	public int getMinimum() {
		return minimum;
	}
	
	/**
	 * Set the value for minimum.
	 * @param minimum The value for minimum
	 */
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
	/** 
	 * @return Get the maximum value since configuration
	 */
	public int getMaximum() {
		return maximum;
	}
	
	/**
	 * Set the value for maximum.
	 * @param maximum The value for maximum.
	 */
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
}
