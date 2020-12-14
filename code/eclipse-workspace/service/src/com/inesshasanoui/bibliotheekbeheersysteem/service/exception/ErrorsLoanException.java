package com.inesshasanoui.bibliotheekbeheersysteem.service.exception;

public enum ErrorsLoanException {
		
		copyAlreadyReturned(1," this copy is already returned."),
		memberNotActive(2,"This member is not active."),
		copyNotAvailableForLoan(3,"Copy is loaned and not available now for Loan"),
		tooManyLoanBooks(4,"too many loaned books"),
		loanIsReturned(5,"loanIsReturned, could not Renewed"),
		itemIsReservedByAnotherPerson (6,"item is reserved by another person");
		 

		  private final int code;
		  private final String message;

		  ErrorsLoanException(int code, String message) {
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
