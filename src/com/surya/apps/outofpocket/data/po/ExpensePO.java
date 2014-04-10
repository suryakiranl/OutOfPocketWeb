package com.surya.apps.outofpocket.data.po;

import java.util.Date;

public class ExpensePO extends NamedPO {
	private double amount;
	private Date billDate;
	private Long groupId;
	private Long expenseTypeID;

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

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getExpenseTypeID() {
		return expenseTypeID;
	}

	public void setExpenseTypeID(Long expenseTypeID) {
		this.expenseTypeID = expenseTypeID;
	}

	@Override
	public String toString() {
		return "ExpensePO [amount=" + amount + ", billDate=" + billDate
				+ ", groupId=" + groupId + ", expenseTypeID=" + expenseTypeID
				+ ", getName()=" + getName() + ", getId()=" + getId()
				+ ", getModifiedBy()=" + getModifiedBy()
				+ ", getModifiedTime()=" + getModifiedTime()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getCreatedTime()="
				+ getCreatedTime() + "]";
	}
}
