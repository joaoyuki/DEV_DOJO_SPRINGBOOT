package br.com.jfassis.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.jfassis.errors.ResourceNotFoundDetails;
import br.com.jfassis.errors.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
		ResourceNotFoundDetails details = new ResourceNotFoundDetails("Resource not found", HttpStatus.NOT_FOUND.value(), resourceNotFoundException.getMessage(), new Date().getTime(), resourceNotFoundException.getClass().getName());
		
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}

}
