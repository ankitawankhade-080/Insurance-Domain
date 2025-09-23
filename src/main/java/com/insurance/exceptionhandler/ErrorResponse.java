package com.insurance.exceptionhandler;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	private final LocalDateTime timeStamp;
	private final int status;
	private final String message;
	
	public ErrorResponse(LocalDateTime timeStamp, int status, String message) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.message = message;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
	
	
	
	

}
