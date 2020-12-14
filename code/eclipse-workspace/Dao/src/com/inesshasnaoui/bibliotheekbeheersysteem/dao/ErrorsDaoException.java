package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

public enum ErrorsDaoException {

		
		noUser(1," user doesn't exist."),
		noItem(2," item doesn't exist."),
		noCopyItem(3," copy doesn't exist."),
		noLoan(4," loan doesn't exist."),
		noReservation(5," reservation doesn't exist."),
		loginError(7,"Wrong Username/Password!"),
		dbDriverError(6,"Could not retrieve data ");		 

		  private final int code;
		  private final String message;

		  ErrorsDaoException(int code, String message) {
		     this.code = code;
		     this.message = message;
		  }

		  public int getCode() { return code; }
		  public String getMessage() { return message; }
		
		  @Override
		  public String toString() {
		    return "error :" +code + ": " + message;
		  }
}


