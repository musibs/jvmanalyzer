package com.codefountain.jvmanalyzer.exception;

public class ConnectionException extends RuntimeException{
	
	private static final long serialVersionUID = -6379001054722861932L;
	
	public ConnectionException(String message){
		super(message);
	}

}
