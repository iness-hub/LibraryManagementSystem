package com.inesshasanoui.bibliotheekbeheersysteem.model;

import java.util.ArrayList;

public class Category {
	private int id;
	private CategoryItem name;
	private ArrayList<Item> items;
	
	public Category(int id, CategoryItem name, ArrayList<Item> items)
	{
		super();
		this.id = id;
		this.name = name;
		this.items = items;
	}
	
	public Category(int id, CategoryItem name)
	{
		super();
		this.id = id;
		this.name = name;
		
	}
	public Category(int id)
	{
		super();
		this.id = id;
		
	}
	public Category( CategoryItem name)
	{
		this.name = name;
		
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public CategoryItem getName()
	{
		return name;
	}

	public void setName(CategoryItem name) 
	{
		this.name = name;
	}

	public ArrayList<Item> getItems()
	{
		return items;
	}

	public void setItems(ArrayList<Item> items) 
	{
		this.items = items;
	}
	
	

}
