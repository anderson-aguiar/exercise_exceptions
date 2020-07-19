package model.entities;

import model.exceptions.DomainExceptions;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {

	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithDrawLimit() {
		return withdrawLimit;
	}

	public void setWithDrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		if (balance < amount) {
			throw new DomainExceptions("Not enough balance");
		}else if(withdrawLimit < amount) {
			throw new DomainExceptions("The amount exceeds withdraw limit");
		}
		balance -= amount;
	}
	@Override
	public String toString() {
		return "New Balance: $ "
				+ balance;
	}

}
