package com.inesshasanoui.bibliotheekbeheersysteem.model;

import java.util.ArrayList;

public class RoleUser {
	
	private String name;
	private ArrayList<User> users;
	
	public RoleUser(String name, ArrayList<User> users) {
		super();
		
		this.name = name;
		this.users = users;
	}
	public RoleUser( String name) {
		super();
		
		this.name = name;
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	
}
