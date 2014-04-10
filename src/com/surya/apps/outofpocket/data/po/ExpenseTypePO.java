package com.surya.apps.outofpocket.data.po;

public class ExpenseTypePO extends NamedPO {
	private String description;
	private Long ownerId;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "ExpenseTypePO [description=" + description + ", ownerId="
				+ ownerId + ", getName()=" + getName() + ", getId()=" + getId()
				+ ", getModifiedBy()=" + getModifiedBy()
				+ ", getModifiedTime()=" + getModifiedTime()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getCreatedTime()="
				+ getCreatedTime() + "]";
	}
}
