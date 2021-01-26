package model;

import exception.InsufficientFundsException;

public class Account {

	private int accountId;
	private int personId;
	private double amount;
	private double interest;
	private TypeAccount type;

	public Account() {
		super();
	}

	public Account(int accountId, int personId, double amount, double interest, TypeAccount type) {
		super();
		this.accountId = accountId;
		this.personId = personId;
		this.amount = amount;
		this.interest = interest;
		this.type = type;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public TypeAccount getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", personId=" + personId + ", amount=" + amount + ", interest="
				+ interest + ", type=" + type + "]";
	}

	public void transferTo(Account account, double amount) throws InsufficientFundsException {
		if (amount > this.getAmount())
			throw new InsufficientFundsException("Insufficient funds");
		this.amount -= amount;
		account.setAmount(account.getAmount() + amount);

	}

	public void transferTo(CreditCard creditCard, double amount) throws InsufficientFundsException {
		if (amount > this.getAmount())
			throw new InsufficientFundsException("Insufficient funds");
		this.amount -= amount;
		creditCard.setCurrentBalance(creditCard.getCurrentBalance() - amount);
	}
}
