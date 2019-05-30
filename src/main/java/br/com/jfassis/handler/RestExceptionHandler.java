package br.com.jfassis.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import br.com.jfassis.errors.ErrorDetail;
import br.com.jfassis.errors.ResourceNotFoundDetails;
import br.com.jfassis.errors.ResourceNotFoundException;
import br.com.jfassis.errors.ValidationErrorDetails;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
		ResourceNotFoundDetails details = new ResourceNotFoundDetails("Resource not found", HttpStatus.NOT_FOUND.value(), resourceNotFoundException.getMessage(), new Date().getTime(), resourceNotFoundException.getClass().getName());
		
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
//		
//		List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
//		String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
//		String Fieldmessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
//		ValidationErrorDetails details = new ValidationErrorDetails(fields, Fieldmessages);
//		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
//	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorDetail error = new ErrorDetail();
		error.setDetail(ex.getMessage());
		error.setDeveloperMessage(ex.getClass().getName());
		error.setStatus(status.value());
		error.setTimestamp(new Date().getTime());

		return new ResponseEntity<Object>(error, headers, status);
	}	

}
