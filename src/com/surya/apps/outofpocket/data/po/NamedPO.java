package com.surya.apps.outofpocket.data.po;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * Mapped super class for all entities that contain a 
 * name as part of their properties.
 * 
 * @author surya
 *
 */
@Entity
@MappedSuperclass
public class NamedPO extends BasePO {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "NamedPO [name=" + name + ", getId()=" + getId()
				+ ", getModifiedBy()=" + getModifiedBy()
				+ ", getModifiedTime()=" + getModifiedTime()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getCreatedTime()="
				+ getCreatedTime() + "]";
	}
}
