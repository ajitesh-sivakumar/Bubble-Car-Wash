package com.ajitesh.Bubble.Car.Wash.exception;

import java.time.LocalDateTime;

public class CustomErrorResponse {
	
	private LocalDateTime timestamp;
	private String message;
    private String details;

	public CustomErrorResponse(String details, String message , LocalDateTime timestamp) {
        super();
        this.message = details;
        this.details = message;
        this.setTimestamp(timestamp);
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
  
    
    
}
