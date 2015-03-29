package com.dhanya.service.exception;

/**
 * Exception thrown when a search result has null value
 * @author Leela Gutta
 *
 */
public class CustomerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String message) {
        super(message);
    }	

}
