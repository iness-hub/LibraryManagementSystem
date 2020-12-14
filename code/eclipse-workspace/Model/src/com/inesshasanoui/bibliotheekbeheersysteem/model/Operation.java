package com.inesshasanoui.bibliotheekbeheersysteem.model;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class Operation {
	
	private int userId;
	private Date operationDate;
	private Member member;
	
	public Operation(int userId, Date operationDate, Member member) {
		super();
		this.userId = userId;
		this.operationDate = operationDate;
		this.member = member;
	}
	
	public Operation(int userId, Date operationDate) {
		super();
		this.userId = userId;
		this.operationDate = operationDate;
		
	}
	public Operation () {}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date date) {
		this.operationDate = date;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	
}
