package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

import java.util.ArrayList;



import com.inesshasanoui.bibliotheekbeheersysteem.model.User;



public interface AuthenticationDao {
	User login(String username, String password) throws DaoException, NotFoundDaoException;
	 User register(User user);
}
