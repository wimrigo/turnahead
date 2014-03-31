package com.programmeren4.turnahead.server.model.jpa;


import java.io.Serializable;
import java.util.Date;


/**
 * Karakter
 * 
 */

public class CharacterEnt implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributen
    private long characterId; // Long voor JPA, Key voor JPA + GAE
	
	private String characterName;
	
    private Date lastLogin;
	
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
	
	public long getCharacterId() {
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
