package com.surya.apps.outofpocket.business.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "group")
public class GroupDTO extends NamedDTO {
	private Long ownerId;

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "GroupDTO [ownerId=" + ownerId + ", getName()=" + getName()
				+ ", getId()=" + getId() + ", getModifiedBy()="
				+ getModifiedBy() + ", getModifiedTime()=" + getModifiedTime()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getCreatedTime()="
				+ getCreatedTime() + "]";
	}

}
