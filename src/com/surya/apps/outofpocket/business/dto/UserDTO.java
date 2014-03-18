package com.surya.apps.outofpocket.business.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class UserDTO extends NamedDTO {
	private String email;
	private String password;
	private boolean active;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
