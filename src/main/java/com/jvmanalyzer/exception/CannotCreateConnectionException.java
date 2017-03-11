package com.jvmanalyzer.exception;

public class CannotCreateConnectionException extends RuntimeException{
	
	private static final long serialVersionUID = -6379001054722861932L;
	
	public CannotCreateConnectionException(String message){
		super(message);
	}

}
