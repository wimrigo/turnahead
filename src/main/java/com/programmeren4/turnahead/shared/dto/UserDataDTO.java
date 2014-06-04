package com.programmeren4.turnahead.shared.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Gebruiker
 * 
 */
public class UserDataDTO implements Serializable {
	// attributen
	private static final long serialVersionUID = 1L;
	private Long userId; // int userId;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private Date lastLogin;
	private Date registrationDate;

	// constructor (?)
	public UserDataDTO(Long userId, String firstName, String lastName, String eMail,
			String password) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
	}
	
	
	public UserDataDTO(String firstName, String lastName, String eMail,
			String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
	}
	
	
	public UserDataDTO() {
		super();
	}

	// getters en setters
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userID) {
		this.userId = userID;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDataDTO other = (UserDataDTO) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	
	
	
}