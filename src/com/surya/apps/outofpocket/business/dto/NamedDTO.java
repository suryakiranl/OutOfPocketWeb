package com.surya.apps.outofpocket.business.dto;

public class NamedDTO extends BaseDTO {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() + ",name=" + name;
	}
}
