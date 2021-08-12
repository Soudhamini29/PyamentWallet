package com.cg.paymentapp.exceptions;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<MyErrorDetails> handleAccountNotFoundException(AccountNotFoundException exp,WebRequest req){
		
		
		MyErrorDetails err=new MyErrorDetails(exp.getMessage(),LocalDateTime.now(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<MyErrorDetails> handleCustomerNotFoundException(CustomerNotFoundException exp,WebRequest req){
		
		
		MyErrorDetails err=new MyErrorDetails(exp.getMessage(),LocalDateTime.now(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(InsufficientAmountException.class)
	public ResponseEntity<MyErrorDetails> handleInsufficientException(InsufficientAmountException exp,WebRequest req){
		
		
		MyErrorDetails err=new MyErrorDetails(exp.getMessage(),LocalDateTime.now(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	

	@ExceptionHandler(NoTransactionFoundException.class)
	public ResponseEntity<MyErrorDetails> handleNoTransactionFoundException(NoTransactionFoundException exp,WebRequest req){
		
		
		MyErrorDetails err=new MyErrorDetails(exp.getMessage(),LocalDateTime.now(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> handleException(MethodArgumentNotValidException exp,WebRequest req){
		
		
		MyErrorDetails err=new MyErrorDetails(exp.getMessage(),LocalDateTime.now(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> handleException(Exception exp,WebRequest req){
		
		
		MyErrorDetails err=new MyErrorDetails(exp.getMessage(),LocalDateTime.now(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
		
	
}
