package com.inesshasanoui.bibliotheekbeheersysteem.model;

import java.util.Date;

public abstract class User {
	
private  int id;
private UserState state;
private String username;
private String password;
public Person person;


public User(int id, UserState state,UserRole role, String username, String password, String firstname, String lastname,
		String adres, String email, int tel) {
	
	this.id = id;
	this.state = state;
	this.username = username;
	this.password = password;
	this.person= new Person(firstname, lastname,adres, email, tel);
}

/*public static User getUser(int id, UserState state,  UserRole role, String username, String password, String firstname, String lastname,
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

public UserRole getRoleUser() {
	
	UserRole userRole = null;
	if ( this instanceof Member) userRole= UserRole.member;
	else userRole= UserRole.librarian;
	return userRole;
}

*/
public int getId() {
	return id;
}

public UserState getState() {
	return state;
}

public String getUsername() {
	return username;
}

public String getPassword() {
	return password;
}

 public Person getPerson() {
	return person;
}

public void setPerson(Person person) {
	this.person = person;
}

public void setId(int id) {
	this.id = id;
}

public void setState(UserState state) {
	this.state = state;
}

public void setUsername(String username) {
	this.username = username;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
 public String toString() {
	 return "******************User************************"+"\n"+
 			 "firstname : " + this.person.getFirstname()+ "\n"+
			 "lastname: "+ this.person.getLastname() + "\n" +
			 "tel : " + this.person.getTel() + "\n";
			 
				
 }



}
