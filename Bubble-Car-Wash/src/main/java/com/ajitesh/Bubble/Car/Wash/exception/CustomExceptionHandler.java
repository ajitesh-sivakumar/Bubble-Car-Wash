package com.ajitesh.Bubble.Car.Wash.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoEntryFoundException.class)
    public final ResponseEntity<CustomErrorResponse> handleNoEntryFoundException (NoEntryFoundException ex, WebRequest request) 
    {
        CustomErrorResponse error = new CustomErrorResponse(ex.getLocalizedMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(InvalidRegistrationException.class)
	public final ResponseEntity<CustomErrorResponse> handleInvalidRegistrationException (InvalidRegistrationException ex, WebRequest request) 
    {
        CustomErrorResponse error = new CustomErrorResponse(ex.getLocalizedMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(NoEntryForDateException.class)
	public final ResponseEntity<CustomErrorResponse> handleAllOtherExceptions (NoEntryForDateException ex, WebRequest request) 
    {
        CustomErrorResponse error = new CustomErrorResponse(ex.getLocalizedMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(NoCarTypeForDateException.class)
	public final ResponseEntity<CustomErrorResponse> handleAllOtherExceptions (NoCarTypeForDateException ex, WebRequest request) 
    {
        CustomErrorResponse error = new CustomErrorResponse(ex.getLocalizedMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<CustomErrorResponse> handleAllOtherExceptions (Exception ex, WebRequest request) 
    {
        CustomErrorResponse error = new CustomErrorResponse(ex.getLocalizedMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
