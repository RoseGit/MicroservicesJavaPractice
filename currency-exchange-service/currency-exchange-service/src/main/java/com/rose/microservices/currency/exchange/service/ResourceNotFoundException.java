package com.rose.microservices.currency.exchange.service;

public class ResourceNotFoundException extends RuntimeException{

	private int code;
	public ResourceNotFoundException(String message, int code) {
		super(message);
		this.code = code;
	}
	
	
	public int getCode() {
		return code;
	}
}
