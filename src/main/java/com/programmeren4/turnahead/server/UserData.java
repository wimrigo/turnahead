package com.programmeren4.turnahead.server;


import java.util.Date;

/*
We gaan JPA gebruiken..

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
*/

public class UserData {
	
	//voorbeeld voor aanspreking database
	// weet momenteel de namen van de velden niet dus (note/id) gebruikt
	private Long id;
	private String note;
	private Date createDate;
 
	//a good way to use constructor
	public UserData() {
		this.createDate = new Date();
	}
 
	public UserData(String symbol) {
		this();
		this.note = symbol;
	}
 
	public Long getId() {
		return this.id;
	}
 
	public String getNote() {
		return this.note;
	}
 
	public Date getCreateDate() {
		return this.createDate;
	}
 
	public void setNote(String note) {
		this.note = note;
	}
}
