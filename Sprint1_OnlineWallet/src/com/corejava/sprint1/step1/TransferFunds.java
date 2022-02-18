package com.corejava.sprint1.step1;

import java.util.*;

public class TransferFunds {
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
			Wallet recipient = createRecipientWallet();
			
			wallet.transferFunds(amount, recipient);
			
			System.out.println("\nUsername: " + wallet.username);
			System.out.println("Current Balance: " + wallet.getBalance());
			
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
