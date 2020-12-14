package com.inesshasanoui.bibliotheekbeheersysteem.service;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Librarian;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Member;
import com.inesshasanoui.bibliotheekbeheersysteem.model.User;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserState;
import com.inesshasanoui.bibliotheekbeheersysteem.service.exception.AuthenticationException;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.AuthenticationDao;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.DaoException;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.NotFoundDaoException;



public class AuthenticationServiceImpl implements AuthenticationService {
	private AuthenticationDao authenticationDao;

	public AuthenticationServiceImpl(AuthenticationDao authenticationDao) {
		super();
		this.authenticationDao = authenticationDao;
	}

/*	@Override
	public User login(String username, String password) throws AuthenticationException {
		User user;
		try {
			 user = authenticationDao.login(username, password);
			if (user==null) {
				throw new AuthenticationException("combination username and password wrong");
			}else if (user.getState()!= UserState.active) {
					throw new AuthenticationException("user not Active");
				
			}else {
				return user;
			}
			
			
		} catch (DaoException e) {
			throw new AuthenticationException("something is wrong met retrieving information",e);
		}
	}*/
	
	@Override
	public User login(String username, String password) throws AuthenticationException {
		User user;
		try {
			 user = authenticationDao.login(username, password);
				return user;
			} 	
		catch (NotFoundDaoException ex){
			throw new AuthenticationException("wrong passsword and name",ex);
		}
		catch (DaoException e) {
			throw new AuthenticationException("something is wrong met retrieving information",e);
		}
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return authenticationDao.register(user);
	}

	@Override
	public Boolean hasPermissionMember(User user) {
	  return user instanceof Member;
		
	}

	@Override
	public Boolean hasPermissionLibrarian(User user) {
		 return user instanceof Librarian;
	}

}
