package com.rose.rest.webservices.restful.web.services.helloworld;

/**
 * A simple bean with a single property
 */
public class HelloWorldBean {

	private String message;
	
	/***
	 * Default constructor
	 * @param message
	 */
	public HelloWorldBean(String message) {
		this.message = message;
	}

	/**
	 * Gets the value of message
	 * @return the value of message property
	 */
	public String getMessage() {
		return message;
	}

	/***
	 * Sets the value of message
	 * @param message the value to set.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * See {@link String}
	 */
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
}
