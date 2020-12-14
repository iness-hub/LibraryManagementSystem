package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

public class NotFoundDaoException extends Exception {

	public NotFoundDaoException(String message) {
		super(message);
		}

	public NotFoundDaoException(String message, Exception e1) {
		super(message,e1);
	}

}
