package com.corejava.sprint1.step1;

import java.util.*;

public class Register {
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
		
		if(username != null && password != null && confirmPassword != null) {
			
			if(confirmPassword.equals(password)) {
				
				Wallet wallet = new Wallet(username, password);
				
				System.out.println("\nAll fields validated!");
				System.out.println("\nRegistration Successful!");
				
				signedIn = true;
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
}
