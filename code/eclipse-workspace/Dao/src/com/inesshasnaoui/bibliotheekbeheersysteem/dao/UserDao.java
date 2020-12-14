package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Loan;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Member;
import com.inesshasanoui.bibliotheekbeheersysteem.model.User;

public interface UserDao extends CrudDao<User> {
	
	// checkStateUser
	//getTotalItemsCheckedOut
//	List<Loan>getCurrentLoans(int userId);
	 User get(String firstname,String lastname);
}
