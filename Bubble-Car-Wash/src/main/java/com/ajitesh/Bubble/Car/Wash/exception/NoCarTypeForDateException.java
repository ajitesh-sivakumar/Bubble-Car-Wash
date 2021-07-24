package com.ajitesh.Bubble.Car.Wash.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoCarTypeForDateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoCarTypeForDateException(String message) {
        super(message);
    }
}