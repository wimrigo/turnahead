package com.programmeren4.turnahead.server.model.jpa;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;


/**
 * Karakter
 * 
 */

@Entity
public class CharacterEnt implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributen
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key characterId; // Long voor JPA, Key voor JPA + GAE
	
	@Basic
	private String characterName;
	
	@Basic
    private Date lastLogin;
	
	@Basic
    private Date registrationDate;
    
    //constructor
	/*public CharacterEnt(Key characterId, String characterName, Date lastLogin,
			Date registrationDate) {
		this.characterId = characterId;
		this.characterName = characterName;
		this.lastLogin = lastLogin;
		this.registrationDate = registrationDate;
	}*/
	
	public CharacterEnt(String characterName, Date lastLogin, Date registrationDate) {
		this.characterName = characterName;
		this.lastLogin = new Date();
		this.registrationDate = new Date();
	}
	
	public Key getCharacterId() {
		return characterId;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    
    public Date getLastLogine() {
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

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
}
