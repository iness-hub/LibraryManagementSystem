package com.inesshasanoui.bibliotheekbeheersysteem.service.exception;

public class LoanException extends Exception {

	public LoanException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public LoanException(String message) {
		super(message);
		
	}

}
