package com.inesshasanoui.bibliotheekbeheersysteem.model;

public class Person {

	private String firstname;
	private  String lastname;
	private String adres;
	private String email;
	private int tel;
	
	public Person(String firstname, String lastname, String adres, String email, int tel) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.adres = adres;
		this.email = email;
		this.tel = tel;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAdres() {
		return adres;
	}

	public String getEmail() {
		return email;
	}

	public int getTel() {
		return tel;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}
	
	
	
}
