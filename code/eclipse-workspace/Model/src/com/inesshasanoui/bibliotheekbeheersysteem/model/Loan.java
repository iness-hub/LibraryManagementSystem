package com.inesshasanoui.bibliotheekbeheersysteem.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Loan //extends Operation
{
	private int id;
	private int copyId;
	private int userId;
	private Date returnDate;
	private Date returnedDate;
	private Float penality;
	private CopyItem copyItem;
	private Date dateLoaned;
	private Member member;
	
	public Loan(int id,int userId,int copyId,Date dateLoaned,Date returnDate,Date returnedDate, Float penality, Member member, CopyItem copyItem)
	{
		
		
		this.id=id;
		this.userId=userId;
		this.dateLoaned= dateLoaned;
		this.copyId=copyId;
		this.returnDate=returnDate;
		this.returnedDate=returnedDate;
		this.penality=penality;
		this.copyItem = copyItem;
	}
	
	public Loan(int id,int userId,int copyId,Date dateLoaned,Date returnDate,Date returnedDate, Float penality)
	{
		this.id=id;
		this.userId=userId;
		this.dateLoaned= dateLoaned;
		this.copyId=copyId;
		this.returnDate=returnDate;
		this.returnedDate=returnedDate;
		this.penality=penality;
		
	}
	public Loan(int userId,int copyId,Date dateLoaned,Date returnDate,Date returnedDate, Float penality)
	{
		this.userId=userId;
		this.dateLoaned= dateLoaned;
		this.copyId=copyId;
		this.returnDate=returnDate;
		this.returnedDate=returnedDate;
		this.penality=penality;
		
	}

	public Loan(int userId, Date dateLoaned, Member member, int id, int copyId, Date returnDate,
			CopyItem copyItem) {
		this.userId=userId;
		this.dateLoaned= dateLoaned;
		this.id = id;
		this.copyId = copyId;
		this.returnDate = returnDate;
		this.copyItem = copyItem;
		this.member=member;
	}


	/*public Loan() {
		// TODO Auto-generated constructor stub
	}
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCopyId() {
		return copyId;
	}

	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	public Float getPenality() {
		return penality;
	}

	public void setPenality(Float penality) {
		this.penality = penality;
	}

	public CopyItem getCopyItem() {
		return copyItem;
	}

	public void setCopyItem(CopyItem copyItem) {
		this.copyItem = copyItem;
	}

	public Date getDateLoaned() {
		return dateLoaned;
	}

	public void setDateLoaned(Date dateLoaned) {
		this.dateLoaned = dateLoaned;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}



	
	
	
	
	
}
