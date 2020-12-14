package com.inesshasanoui.bibliotheekbeheersysteem.model;

public class UserFactory {
	
	public static User getUser(int id, UserState state,  UserRole role, String username, String password, String firstname, String lastname,
			String adres, String email, int tel) {
		User user = null;
		switch (role) {
		case librarian :
			user = new Librarian(id,state,role,username,password,firstname,lastname,adres,email,tel);
			break;
		case member :
			user= new Member(id,state,role,username,password,firstname,lastname,adres,email,tel);
			break;
			}
		return user;
	}

	public static UserRole getRoleUser(User user) {
		
		UserRole userRole = null;
		if ( user instanceof Member) userRole= UserRole.member;
		else userRole= UserRole.librarian;
		return userRole;
	}


}
