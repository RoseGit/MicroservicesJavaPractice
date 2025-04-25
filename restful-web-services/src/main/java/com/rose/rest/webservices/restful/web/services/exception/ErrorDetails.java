package com.rose.rest.webservices.restful.web.services.exception;

import java.time.LocalDateTime;

/**
 * Contains customized information for error handling.
 */
public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String details;
	
	/**
	 * Default constructor.
	 * @param timestamp The date and time when the exception occurred.
	 * @param message The exception message.
	 * @param details Extra information about the exception.
	 */
	public ErrorDetails(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	/***
	 * Get date and time about the exception.
	 * @return
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/***
	 * Get message about the exception.
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Get extra information about the exception.
	 * @return
	 */
	public String getDetails() {
		return details;
	}
}
