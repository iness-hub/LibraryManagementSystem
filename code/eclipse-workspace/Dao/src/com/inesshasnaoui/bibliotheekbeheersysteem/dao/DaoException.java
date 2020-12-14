package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

public class DaoException extends Exception {

	public DaoException(String message) {
		super(message);
		}

	public DaoException(String message, Exception e1) {
		super(message,e1);
	}

}
