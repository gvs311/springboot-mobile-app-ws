package com.springbootexample.app.ws.exceptions;

public class UserServiceException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6872508993643955173L;

	public UserServiceException(String message) {
		super(message);
	}
}
