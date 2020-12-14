package com.inesshasanoui.bibliotheekbeheersysteem.service;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Member;
import com.inesshasanoui.bibliotheekbeheersysteem.model.User;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserState;
import com.inesshasanoui.bibliotheekbeheersysteem.service.exception.AuthenticationException;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.AuthenticationDao;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.DaoException;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.UserDao;

public class UserServiceImpl implements UserService {
	UserDao userDao;
	AuthenticationDao authenticationDao;

	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}



	@Override
	public User insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public User update(User user) {
		
		return userDao.update(user);
	}

	@Override
	public boolean delete(User user) {
		return userDao.delete(user);
	}

	@Override
	public User get(long id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User get(String firstname, String lastname) {
		
		return userDao.get(firstname,lastname);
	}

	/*@Override
	public Boolean hasPermissionMember(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean hasPermissionLibrarian(User user) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public Boolean memberIsAllowedToLoan(int userId) {
		String state =userDao.get(userId).getState().toString();
		return state.equals(UserState.active.toString());
	}

}
