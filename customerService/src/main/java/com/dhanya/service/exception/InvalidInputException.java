package com.dhanya.service.exception;

import org.springframework.validation.BindingResult;
/**
 * @author Leela Gutta
 * 
 */

public class InvalidInputException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	private BindingResult bindingResult;

	public InvalidInputException(String message) {
		super(message);
	}

	public InvalidInputException(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

	public BindingResult getResult() {
		return bindingResult;
	}
}