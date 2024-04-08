package com.app.craftdemo.exception;

public class StudentNotFoundException extends Exception{
	
	private static final long serialVersionUID = 100001L;
	public StudentNotFoundException() {
		super();
	}
	public StudentNotFoundException(String message) {
		super(message);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
