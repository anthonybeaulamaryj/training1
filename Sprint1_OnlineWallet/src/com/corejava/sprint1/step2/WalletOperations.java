package com.corejava.sprint1.step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WalletOperations {
	
	Wallet signUp() {
		System.out.println("\n-------Registration Module-------");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nEnter Username: ");
		String username = sc.next();
		
		System.out.println("\nEnter Password: ");
		String password = sc.next();
		
		System.out.println("\nConfirm Password: ");
		String confirmPassword = sc.next();
		
		boolean signedIn = false;
		
		List<Wallet> walletList = new ArrayList<>();
		
		if(username != null && password != null && confirmPassword != null) {
			
			if(confirmPassword.equals(password)) {
				
				Wallet wallet = new Wallet(username, password);
				
				System.out.println("\nAll fields validated!");
				System.out.println("\nRegistration Successful!");
				
				signedIn = true;
				
				walletList.add(wallet);
				
				return wallet;
			}
			
			else {
				System.out.println("\nPassword does not Match! \n\nRe-enter Credentials:");
				signUp();
			}
		}
		else {
			System.out.println("\nInvalid Credentials: Values should not be null! \n\nRe-enter Credentials:");
			signUp();
		}
		return null;
	}
	
	
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
	
	void transferFunds(Wallet wallet) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the recipient wallet Account number: ");
		String accNo = sc.next();
		
		System.out.println("\nEnter the amount to transfer: ");
		int amount = sc.nextInt();
		
		if(amount > wallet.getBalance()) {
			
			System.out.println("Entered amount greater than Account Balance!");
			System.out.println("Transaction Cancelled!");
			return;
		}
		
		System.out.println("\nConfirm Details:");
		System.out.println("\nUsername: " + wallet.username);
		System.out.println("Current Balance: " + wallet.balance);
		System.out.println("Recipient Account number: " + accNo);
		
		System.out.println("\nEnter your choice: ");
		System.out.println("1. Confirm Transfer Request");
		System.out.println("2. Cancel Transfer Request");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1:
			// creating a recipient for demonstration of transferring funds
			Wallet recipient = createRecipientWallet(); 
			
			wallet.transferFunds(amount, recipient);
			
			System.out.println("\nUsername: " + wallet.username);
			System.out.println("Current Balance: " + wallet.getBalance());
			
			//Printing recipient's balance for demonstration of transfer funds 
			System.out.println("\nRecipient Username: " + recipient.username);
			System.out.println("Recipient Current Balance: " + recipient.getBalance());
			return;
			
		case 2:
			System.out.println("\nTransfer Request Cancelled!");
			return;
			
		default:
			System.out.println("\nInvalid Choice!");
			transferFunds(wallet);
			return;
		}
	}
	
	Wallet createRecipientWallet() {
		
		Wallet recipientWallet = new Wallet("Recipient", "recipient@123");
		return recipientWallet;
	}
}
