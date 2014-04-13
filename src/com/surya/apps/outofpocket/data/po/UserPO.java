package com.surya.apps.outofpocket.data.po;

import javax.persistence.Entity;

/**
 * Persistent Object for Users data store element.
 * 
 * @author surya
 *
 */
@Entity
public class UserPO extends NamedPO {
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

	@Override
	public String toString() {
		return "UserPO [email=" + email + ", active=" + active + ", getName()="
				+ getName() + ", getId()=" + getId() + ", getModifiedBy()="
				+ getModifiedBy() + ", getModifiedTime()=" + getModifiedTime()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getCreatedTime()="
				+ getCreatedTime() + "]";
	}
}
