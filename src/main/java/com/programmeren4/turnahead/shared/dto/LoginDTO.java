package com.programmeren4.turnahead.shared.dto;

import java.io.Serializable;

/**
 * Login
 * 
 */
public class LoginDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;

	public LoginDTO() {
		super();
	}

	public LoginDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEMail() {
		return email;
	}

	public void setEMail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + ((userId == null) ? 0 : userId.hashCode());
	// return result;
	// }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDTO object = (LoginDTO) obj;
		if (this.getEMail() != object.getEMail())
			return false;
		if (this.getPassword() != object.getPassword())
			return false;
		return true;
	}

}
