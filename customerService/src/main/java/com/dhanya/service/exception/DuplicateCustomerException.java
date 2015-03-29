package com.dhanya.service.exception;

public class DuplicateCustomerException extends RuntimeException {
/**
 * Custom Exception class for duplicate values. 
 * customer Repository throws this error when ever client tries to register with existing unique id
 * (in our case its phone number)
 * @author Leela Gutta
 */
	
	private static final long serialVersionUID = 1L;

	public DuplicateCustomerException(String message) {
        super(message);
    }
}
