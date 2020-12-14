package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Loan;

public interface LoanDao extends CrudDao<Loan> {

	List<Loan>getCurrentLoans(int userId);
	int countCurrentLoans(int userId);
	 Loan getLoanedcopyItem(int copyId);
}
