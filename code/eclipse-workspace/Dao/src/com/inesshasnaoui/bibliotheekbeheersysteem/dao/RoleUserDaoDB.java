package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Member;
import com.inesshasanoui.bibliotheekbeheersysteem.model.RoleUser;
import com.inesshasanoui.bibliotheekbeheersysteem.model.User;


public class RoleUserDaoDB implements RoleUserDao {
	private ConnectSql connectSql;
	
	public RoleUserDaoDB(ConnectSql connectSql) {
		this.connectSql = connectSql;
	}
	@Override
	public RoleUser insert(RoleUser roleUser) {
	
		String query = "INSERT INTO role";
		query += "(name)";
		query += "VALUE ('" + roleUser.getName() + "'"+")";
		connectSql.insertQuery(query);
		return roleUser;
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
		return null;
	}

	@Override
	public List<RoleUser> getAll() {
		String query = "SELECT * FROM role";
		ResultSet rs = connectSql.selectQuery(query);
		List<RoleUser> list = new ArrayList<>();
		try {
			list = extractListRoleUserFromResultSet(rs);
			System.out.println(list.toString());
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	
	private RoleUser extractRoleUserFromResultSet(ResultSet rs) throws SQLException {
		String name;
		RoleUser roleUser = null;
		try {

			if (rs.next()) {
				name = rs.getString("name");
				roleUser = new RoleUser(name);
			}
			return roleUser;
		} catch (SQLException ex) {
			return null;
		}
	}
	
	private List<RoleUser> extractListRoleUserFromResultSet(ResultSet rs) throws SQLException {
	
		String name;
		List<RoleUser> list = new ArrayList<>();
				try {
			
			while (rs.next()) {
				name = rs.getString("name");
				RoleUser roleUser = new RoleUser( name);
				list.add(roleUser);
			}
			return list;
			
		} catch (SQLException ex) {
			return null;
		}
	}
}
