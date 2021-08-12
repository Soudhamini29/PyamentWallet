package com.cg.paymentapp.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MyErrorDetails {
	
	private String message;
	private LocalDateTime timestamp;
	private String description;
	
	public MyErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public MyErrorDetails(String message, LocalDateTime timestamp, String description) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
