package com.app.craftdemo.exception;

import lombok.Getter;

@Getter
public class StudentNotFoundException extends Exception{
	
	//String message = "";
	public StudentNotFoundException(String message) {
		super(message);
		//this.message = message;
	}


}
