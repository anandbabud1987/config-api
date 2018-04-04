package com.rbc.test.rest.exception;

public class ApiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1707819284291113126L;
	
	public ApiException(String message) {
        super(message);
    }

}
