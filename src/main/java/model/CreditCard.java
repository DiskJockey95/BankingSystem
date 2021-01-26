package model;

import java.sql.Date;

public class CreditCard {

	private int creditCardId;
	private int personId;
	private double currentBalance;
	private double creditLimit;
	private double interest;
	private Date dueDate;
	private TypeCard type;

	public CreditCard() {
		super();
	}

	public CreditCard(int creditCardId, int personId, double currentBalance, double creditLimit, double interest,
			Date dueDate, TypeCard type) {
		super();
		this.creditCardId = creditCardId;
		this.personId = personId;
		this.currentBalance = currentBalance;
		this.creditLimit = creditLimit;
		this.interest = interest;
		this.dueDate = dueDate;
		this.type = type;
	}

	public int getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(int creditCardId) {
		this.creditCardId = creditCardId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public TypeCard getType() {
		return type;
	}

	@Override
	public String toString() {
		return "CreditCard [creditCardId=" + creditCardId + ", personId=" + personId + ", currentBalance="
				+ currentBalance + ", creditLimit=" + creditLimit + ", interest=" + interest + ", dueDate=" + dueDate
				+ ", type=" + type + "]";
	}
}
