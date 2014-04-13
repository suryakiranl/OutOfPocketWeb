package com.surya.apps.outofpocket.data.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Entity to save Expenses in the data store.
 * 
 * @author surya
 *
 */
@Entity
public class ExpensePO extends NamedPO {
	private double amount;
	private Date billDate;

	@ManyToOne(fetch = FetchType.LAZY)
	private GroupPO group;

	@ManyToOne(fetch = FetchType.LAZY)
	private ExpenseTypePO expenseType;

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

	public GroupPO getGroup() {
		return group;
	}

	public void setGroup(GroupPO group) {
		this.group = group;
	}

	public ExpenseTypePO getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(ExpenseTypePO expenseType) {
		this.expenseType = expenseType;
	}

	@Override
	public String toString() {
		return "ExpensePO [amount=" + amount + ", billDate=" + billDate
				+ ", group=" + group + ", expenseType=" + expenseType
				+ ", getName()=" + getName() + ", getId()=" + getId()
				+ ", getModifiedBy()=" + getModifiedBy()
				+ ", getModifiedTime()=" + getModifiedTime()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getCreatedTime()="
				+ getCreatedTime() + "]";
	}

}
