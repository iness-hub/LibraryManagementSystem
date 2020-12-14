package com.inesshasanoui.bibliotheekbeheersysteem.model;

import java.util.ArrayList;
import java.util.List;

public class Dvd extends Item {

	public Dvd(int id, int isbn, String title, String author, TypeItem type, String summary, Category category) {
		super(id, isbn, title, author, type, summary, category);
		// TODO Auto-generated constructor stub
	}

	public Dvd(int id, int isbn, String title, String author, TypeItem type, String summary, Category category,
			List<CopyItem> copies) {
		super(id, isbn, title, author, type, summary, category, copies);
		// TODO Auto-generated constructor stub
	}

	
	
}
