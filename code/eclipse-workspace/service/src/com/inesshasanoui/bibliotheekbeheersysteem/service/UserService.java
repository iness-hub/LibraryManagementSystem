package com.inesshasanoui.bibliotheekbeheersysteem.service;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Member;
import com.inesshasanoui.bibliotheekbeheersysteem.model.User;


public interface UserService extends Service<User>  {
	 User get(String firstname,String lastname);
	 Boolean memberIsAllowedToLoan(int userId);
}
