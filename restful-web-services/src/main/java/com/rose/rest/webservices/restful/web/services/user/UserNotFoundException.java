package com.rose.rest.webservices.restful.web.services.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom User Not Found Exception.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	/**
	 * Default serialized value
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * @param message The exception message.
	 */
	public UserNotFoundException(String message) {
		super(message);
	}
}
