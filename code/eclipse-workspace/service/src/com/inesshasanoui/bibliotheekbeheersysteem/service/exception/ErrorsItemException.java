package com.inesshasanoui.bibliotheekbeheersysteem.service.exception;

public enum ErrorsItemException {
	itemExist(1," item exist already."),
	itemDoesNotExist(2,"item doensn't exist in data base"),
	NoEnteredId(3,"No entered id ,vul id in"),
	noEnteredISBNnumber(4,"no entered ISBN number");
	
	 

	  private final int code;
	  private final String message;

	  ErrorsItemException(int code, String message) {
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
