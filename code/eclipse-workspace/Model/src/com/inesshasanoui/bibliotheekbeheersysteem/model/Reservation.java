package com.inesshasanoui.bibliotheekbeheersysteem.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Reservation
{	
	private int id;
	private int userId;
	private int itemId;
	private int copyIdReserved;
	private Date dateReservation;
	private Item item;
	private Member member;
	private String stateReservation;
	
	public Reservation(int id, int userId, int itemId,int copyIdReserved, Date dateReservation, Item item, Member member,
			String stateReservation) {
		
		this.id = id;
		this.userId = userId;
		this.itemId = itemId;
		this.dateReservation = dateReservation;
		this.copyIdReserved=copyIdReserved;
		this.item = item;
		this.member = member;
		this.stateReservation = stateReservation;
	}
	
		public Reservation(int id, int userId, int itemId, int copyIdReserved, Date dateReservation, String stateReservation) {
		this(id, userId, itemId, copyIdReserved,dateReservation, null, null, stateReservation);
		
	}
	public Reservation(int userId, int itemId, int copyIdReserved, Date dateReservation, String stateReservation) {
	
	//	this.id = id;
		this.userId = userId;
		this.itemId = itemId;
		this.dateReservation = dateReservation;
		this.stateReservation = stateReservation;
		this.copyIdReserved=copyIdReserved;
	}
	

	public String getStateReservation() {
		return stateReservation;
	}

	public void setStateReservation(String stateReservation) {
		this.stateReservation = stateReservation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public int getUserId() {
		return userId;
	}

	public int getItemId() {
		return itemId;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public Item getItem() {
		return item;
	}

	public Member getMember() {
		return member;
	}


	public int getCopyIdReserved() {
		return copyIdReserved;
	}


	public void setCopyIdReserved(int copyIdReserved) {
		this.copyIdReserved = copyIdReserved;
	}
	

	
	
}
