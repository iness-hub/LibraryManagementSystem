package com.inesshasanoui.bibliotheekbeheersysteem.service;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.StateUser;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.StateUserDao;

public class StateUserServiceImpl implements StateUserService {
private StateUserDao stateUserDao;

	public StateUserServiceImpl(StateUserDao stateUserDao) {
	super();
	this.stateUserDao = stateUserDao;
}

	@Override
	public StateUser insert(StateUser obj) {
		
		return stateUserDao.insert(obj) ;
	}

	@Override
	public StateUser update(StateUser obj) {
		return stateUserDao.update(obj);
	}

	@Override
	public boolean delete(StateUser obj) {
		return stateUserDao.delete(obj);
	}

	@Override
	public StateUser get(long id) {
		return stateUserDao.get(id);
	}

	@Override
	public List<StateUser> getAll() {
		return stateUserDao.getAll();
	}

}
