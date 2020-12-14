package com.inesshasanoui.bibliotheekbeheersysteem.model;

import java.util.ArrayList;
import java.util.Date;

public class Member extends User{
	
	private ArrayList<Operation> operation;

	
	
/*	public Member(int id, UserState state, Person person, String username, String password) {
		super(id, state, person, username, password);
		// TODO Auto-generated constructor stub
	}


	public Member(int id, UserState state, String username, String password, String firstname, String lastname,
			String adres, String email, int tel) {
		super(id, state, username, password, firstname, lastname, adres, email, tel);
		// TODO Auto-generated constructor stub
	}



//	public Member(){}
	
	
	public Member(int id, UserState state, UserRole role, String username, String password, Person person) {
		super(id, state, role, username, password, person);
		// TODO Auto-generated constructor stub
	}*/

	public Member(int id, UserState state, UserRole role, String username, String password, String firstname,
			String lastname, String adres, String email, int tel) {
		super(id, state, role, username, password, firstname, lastname, adres, email, tel);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Operation> getOperation()
	{
		return operation;
	}



	public void setOperation(ArrayList<Operation> operation)
	{
		this.operation = operation;
	}



	public ArrayList<Loan> consultLoanedItem()
	{
		    ArrayList<Loan> loans = new ArrayList<>();
	        return loans;
	    
	} 

}
