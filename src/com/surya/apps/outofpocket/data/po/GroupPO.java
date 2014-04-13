package com.surya.apps.outofpocket.data.po;

import javax.persistence.Entity;

@Entity
public class GroupPO extends NamedPO {
	private Long ownerId;

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "GroupPO [ownerId=" + ownerId + ", getName()=" + getName()
				+ ", getId()=" + getId() + ", getModifiedBy()="
				+ getModifiedBy() + ", getModifiedTime()=" + getModifiedTime()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getCreatedTime()="
				+ getCreatedTime() + "]";
	}

}
