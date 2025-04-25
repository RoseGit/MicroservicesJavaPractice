package com.rose.rest.webservices.restful.web.services.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rose.rest.webservices.restful.web.services.user.UserNotFoundException;

/**
 * Class that customizes the actions for a given exception.
 */
@ControllerAdvice
public class CustomizeReponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	/***
	 * Indicates that we want to handle all exceptions
	 * @param ex The exception to handle (usually an instance of {@link Exception})
	 * @param request the current web request {@link WebRequest}
	 * @return A {@link ResponseEntity} with error details
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request){
		//Indica que queremos manejar todas las exceptions
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Indicates that we want to handle only exceptions of type UserNotFoundException
	 * @param ex The Exception to handle {@link UserNotFoundException}
	 * @param request The current web request {@link WebRequest}
	 * @return A {@link ResponseEntity} with error details
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotfoundExceptions(Exception ex, WebRequest request){
		//Indica que queremos manejar solo exceptions de tipo UserNotFoundException
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	/***
	 * Handle messages from validators and return them in an object of the class {@link ErrorDetails}
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		//Manejar los mensajes de los validadores validadores
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(), 
				//ex.getMessage(),
				ex.getFieldError().getDefaultMessage(),
				request.getDescription(false)
			);
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
