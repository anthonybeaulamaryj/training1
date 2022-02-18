package com.corejava.sprint1.step1;

import java.util.*;

public class AddAmount {
	void addAmount(Wallet wallet) {
		System.out.println("\n-----Add Amount to Wallet-----");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nEnter the amount to add: ");
		int amount = sc.nextInt();
		
		System.out.println("\nConfirm Details:");
		System.out.println("\nUsername: " + wallet.username);
		System.out.println("Current Balance: " + wallet.balance);
		
		System.out.println("\nEnter your choice: ");
		System.out.println("1. Confirm Add amount to Wallet");
		System.out.println("2. Cancel Add Request");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1:
			wallet.addBalance(amount);
			System.out.println("\nUpdated Balance: " + wallet.getBalance());
			return;
			
		case 2:
			System.out.println("\nAdd request Cancelled!");
			return;
			
		default:
			System.out.println("\nInvalid Choice!");
			addAmount(wallet);
			return;
		}
	}
}
