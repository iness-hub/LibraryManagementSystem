package com.inesshasanoui.bibliotheekbeheersysteem.model;

import java.util.ArrayList;
import java.util.List;

public class Item {
protected int id;
protected int isbn;
protected String title;
protected String author;
protected String summary;
protected List<CopyItem> copies;
protected Category category;
protected boolean active;

public Item(int id) {
	this.id =id;
}

public Item(int id, int isbn, String title, String author, TypeItem type, String summary,
		Category category) {
	super();
	this.id = id;
	this.isbn = isbn;
	this.title = title;
	this.author = author;
	this.summary = summary;
	this.category = category;
	this.active = true;
}


/*public static Item getItem(int id, int isbn, String title, String author, TypeItem type, String summary, Category category, List<CopyItem> copies) {
	Item item = null;
	switch (type)  {
	case book :
		item = new Book(id, isbn, title, author, type, summary,category,copies);
		break;
	case dvd:
		item = new Dvd(id, isbn, title, author, type, summary,category,copies);
		break;
	
	}
	return item;
}*/
/*
public  TypeItem getTypeItem( ) {
	
	TypeItem typeItem = null;
	if ( this instanceof Book) typeItem= TypeItem.book;
	else typeItem= TypeItem.dvd;
	return typeItem;
}*/

public Item(int id, int isbn, String title, String author, TypeItem type, String summary, Category category, List<CopyItem> copies) {
	super();
	this.id = id;
	this.isbn = isbn;
	this.title = title;
	this.author = author;
	this.summary = summary;
	this.copies = copies;
	this.category = category;
	this.active = true;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


public int getIsbn() {
	return isbn;
}

public void setIsbn(int isbn) {
	this.isbn = isbn;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getSummary() {
	return summary;
}

public void setSummary(String summary) {
	this.summary = summary;
}

public List<CopyItem> getCopies() {
	return copies;
}

public void setCopies(List<CopyItem> copies) {
	this.copies=copies;
}



public Category getCategory() {
	return category;
}



public void setCategory(Category category) {
	this.category = category;
}

public boolean getActive() {
	return active;
}

public void setActive(boolean active) {
	this.active=active;
}


}
