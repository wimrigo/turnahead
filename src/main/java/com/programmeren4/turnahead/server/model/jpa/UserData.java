package com.programmeren4.turnahead.server.model.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * Gebruiker
 * 
 */
@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key userId; //Long key
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
	private Date lastLogin;
    private Date registrationDate;
    
    //constructor
    public UserData(String firstName, String lastName, String eMail, String password){
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.eMail = eMail;
    	this.password = password;
    }
    
    


    public Key getUserId() {
        return userId;
    }

    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
    public String getEMail() {
        return eMail;
    }
    public void setEMail(String EMail) {
        this.eMail = EMail;
    }

    
    public Date getLastLogin() {
        return lastLogin;
    }
    public void setLastLoginDate(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
    
    
    public Date getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    
}
