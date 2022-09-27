package com.example.demo.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.paylods.UserResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends Exception {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?>handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest request)
	{
		ErrorDetails error=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new  ResponseEntity(error,HttpStatus.NOT_FOUND) ;
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>>handleMethodArgsNotValidate(MethodArgumentNotValidException ex)
	{
		Map<String,String>resp=new HashMap<String ,String>();
		
		ex.getBindingResult().getAllErrors().forEach((errors)->
		{
			
			String fieldName=((FieldError)errors).getField();
			String message=errors.getDefaultMessage();
			resp.put(fieldName, message);
			
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
}
