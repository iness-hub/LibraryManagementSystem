package com.inesshasanoui.bibliotheekbeheersysteem.service;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.RoleUser;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.RoleUserDao;

public class RoleUserServiceImpl implements RoleUserService {
	private RoleUserDao roleUserDao;

	public RoleUserServiceImpl(RoleUserDao roleUserDao ) {
		super();
		this.roleUserDao = roleUserDao;
	}

	@Override
	public RoleUser insert(RoleUser obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleUser update(RoleUser obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(RoleUser obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RoleUser get(long id) {
		return roleUserDao.get(id);
		
	}

	@Override
	public List<RoleUser> getAll() {
		
		return roleUserDao.getAll();
	}
}
