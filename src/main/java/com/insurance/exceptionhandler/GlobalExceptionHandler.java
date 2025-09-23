package com.insurance.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException re){
		ErrorResponse error=new ErrorResponse(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(), re.getMessage());
		return new  ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PolicyNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlePolicyNotFoundException(PolicyNotFoundException pf){
		ErrorResponse error=new ErrorResponse(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(), pf.getMessage());
		return new  ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DuplicatePolicyException.class)
	public ResponseEntity<ErrorResponse> handlePolicyNotFoundException(DuplicatePolicyException dP){
		ErrorResponse error=new ErrorResponse(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(), dP.getMessage());
		return new  ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(InvalidPolicyRequestException.class)
	public ResponseEntity<ErrorResponse> handlePolicyNotFoundException(InvalidPolicyRequestException Ie){
		ErrorResponse error=new ErrorResponse(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(), Ie.getMessage());
		return new  ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
}
