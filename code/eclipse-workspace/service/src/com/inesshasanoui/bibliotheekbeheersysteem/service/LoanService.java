package com.inesshasanoui.bibliotheekbeheersysteem.service;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Loan;
import com.inesshasanoui.bibliotheekbeheersysteem.model.User;
import com.inesshasanoui.bibliotheekbeheersysteem.service.exception.LoanException;

public interface LoanService  {
	
	Loan loanCopyItemToMember(User loginUser,int idCopy, int idMember) throws LoanException;
	Loan renewLoanCopyItem(int copyId) throws LoanException;
	Loan renewLoanCopyItem(Loan loan) throws LoanException;
	Loan returnCopyItem (int idCopyItem) throws LoanException;
	Boolean checkMaxLoanToUser(int idMember);
	float penalityAmount (Loan loan);
	Loan get(long id);
	List<Loan> getAll();
	Loan update(Loan loan);
	
}


