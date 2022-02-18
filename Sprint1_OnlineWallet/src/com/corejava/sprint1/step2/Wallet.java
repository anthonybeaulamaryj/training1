package com.corejava.sprint1.step2;

public class Wallet {
	String username;
	String password;
	
	int balance;
	
	public Wallet() {
		super();
	}
	
	public Wallet(String username, String password) {
		
		super();
		this.username = username;
		this.password = password;
		this.balance = 0;
	}
	
	public void addBalance(int amount) {
		this.balance = this.balance + amount;
	}
	
	public void transferFunds(int amount, Wallet recipient) {
		this.balance = this.balance - amount;
		recipient.addBalance(amount);
	}

	public String getUsername() {
		return username;
	}
	
	public int getBalance() {
		return this.balance;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
