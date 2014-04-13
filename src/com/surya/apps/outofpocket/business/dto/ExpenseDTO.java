package com.surya.apps.outofpocket.business.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "expense")
public class ExpenseDTO extends NamedDTO {
	private double amount;
	private Date billDate;
	private GroupDTO group;
	private ExpenseTypeDTO expenseType;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public GroupDTO getGroup() {
		return group;
	}

	public void setGroup(GroupDTO group) {
		this.group = group;
	}

	public ExpenseTypeDTO getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(ExpenseTypeDTO expenseType) {
		this.expenseType = expenseType;
	}

	@Override
	public String toString() {
		return "ExpenseDTO [amount=" + amount + ", billDate=" + billDate
				+ ", group=" + group + ", expenseType=" + expenseType
				+ ", getName()=" + getName() + ", getId()=" + getId()
				+ ", getModifiedBy()=" + getModifiedBy()
				+ ", getModifiedTime()=" + getModifiedTime()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getCreatedTime()="
				+ getCreatedTime() + "]";
	}

}
