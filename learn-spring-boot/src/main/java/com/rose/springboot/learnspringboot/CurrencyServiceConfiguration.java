package com.rose.springboot.learnspringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Map properties to Java objects from the application.properties file.
 */
@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyServiceConfiguration {

	private String url;
	private String username;
	private String key;
	
	/** 
	 * @return the value of url.
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * set the vlaue of url
	 * @param url The value of url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return the value of username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Set the value of username.
	 * @param username The value of username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the value of key
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * set the value of key.
	 * @param key the value of key
	 */
	public void setKey(String key) {
		this.key = key;
	}
}