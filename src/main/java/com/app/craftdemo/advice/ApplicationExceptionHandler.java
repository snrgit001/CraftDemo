package com.app.craftdemo.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.app.craftdemo.exception.StudentNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex){
		
		Map<String, String> errorMap = new HashMap<>();
		//errorMap.put("message", ex.getFieldErrors());
		ex.getBindingResult().getFieldErrors().forEach(error -> {	
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		
		return errorMap;		
	}

	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(StudentNotFoundException.class)
	public Map<String, String> handleInvalidStudent(StudentNotFoundException ex){		
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());	
		return errorMap;		
	}
	
}
