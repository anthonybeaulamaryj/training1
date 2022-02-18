package com.corejava.sprint1.step2;

import java.util.*;

public class PaymentWalletApplication {
	public static void main(String[] args) {
		System.out.println("\n--------Welcome to Payment Wallet Application--------");
		
		System.out.println("\nChoose an option:");
		System.out.println("\n1. Register");
		System.out.println("2. Exit");
		
		System.out.println("\nEnter your option (1/2): ");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		WalletOperations operations = new WalletOperations();
		
		switch(option) {
		case 1:
			//Register register = new Register();
			Wallet wallet = operations.signUp();
			
			int optionMenu;
			
			do {
			
				System.out.println("\n-------Menu-------:");
				System.out.println("\n1. Add Amount to Wallet");
				System.out.println("2. View Wallet Account Balance");
				System.out.println("3. Tranfer Funds");
				System.out.println("4. Exit");
				
				System.out.println("\nEnter your option (1/2/3/4): ");
				
				optionMenu = sc.nextInt();
				
				switch(optionMenu) {
				case 1:
					operations.addAmount(wallet);
					break;
					
				case 2:
					int balance = wallet.getBalance();
					System.out.println("\nUsername: " + wallet.username);
					System.out.println("Current Balance: " + balance);
					break;
				
				case 3:
					operations.transferFunds(wallet);
					break;
					
				case 4:
					System.out.println("\nExited from Payment wallet Application!");
					break;
					
				default:
					System.out.println("Invalid Option!");
					break;
				}
			
			}while(optionMenu != 4);
			
			break;
			
		case 2:
			System.out.println("\nExited from Payment wallet Application!");
			break;
			
		default:
			System.out.println("\nInvalid option!");
			break;
		}
		sc.close();
	}
}
