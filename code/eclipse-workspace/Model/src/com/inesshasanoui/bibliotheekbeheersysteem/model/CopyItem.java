package com.inesshasanoui.bibliotheekbeheersysteem.model;

public class CopyItem {
private int id;
private int barcode;
private String state;
private Item item;
private Boolean active;

public CopyItem(int id, int barcode, String state, Item item) 
{
	super();
	this.id = id;
	this.barcode = barcode;
	this.state = state;
	this.item=item;
	this.active = true;
}

public int getId() 
{
	return id;
}

public void setId(int id)
{
	this.id = id;
}

public int getBarcode()
{
	return barcode;
}

public void setBarcode(int barcode) 
{
	this.barcode = barcode;
}

public String getState() 
{
	return state;
}

public void setState(String state) 
{
	this.state = state;
}

public Item getItem()
{
	return item;
}

public void setItem(Item item)
{
	this.item = item;
}


public boolean getActive() 
{
	return active;
}

public void setActive(boolean active)
{
	this.active = active;
}
}
