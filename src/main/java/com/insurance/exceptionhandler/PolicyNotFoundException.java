package com.insurance.exceptionhandler;

public class PolicyNotFoundException extends RuntimeException{


	public PolicyNotFoundException(String message) {
		super(message);
	}

	

}
