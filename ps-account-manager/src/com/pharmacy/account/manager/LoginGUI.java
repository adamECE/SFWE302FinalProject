package com.pharmacy.account.manager;

import java.util.Scanner;

public class LoginGUI {
	public static void main(String[] args) {
		
		// init Login Variables 
		UserDatabase db = new UserDatabase(); 
		// main loop variables
		String userInput; 
		int userChoice; 
		
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Press 1 to login, press 2 to create an account:");
		userInput = scanner.nextLine();
		userChoice = Integer.parseInt(userInput); 
		
		if (userChoice==1) 
			login(scanner, db); 
		else 
			createAccount(scanner, db); 
	}

	public static void login(Scanner scanner, UserDatabase db) {
		LoginPortal portal = new LoginPortal(db); 
		int loginAttempts = 0; 
		String username, password; 
		boolean loginSuccess = false, loginFailed = false; 
		
		while (!loginSuccess) {
			System.out.println("Please enter your username: ");
			username = scanner.nextLine(); 
			System.out.println("Please enter your password: ");
			password = scanner.nextLine(); 
			
			loginFailed = portal.loginUser(username, password);
			
			if (!loginFailed) {
				System.out.println("Username or password was incorrect - try again.");
				loginAttempts++; 
			} else {
				System.out.println("Login successful");
				System.out.println("You will now be transfered to the login page");
				loginSuccess = true; 
			}
		}
	}
	
	public static void createAccount(Scanner scanner, UserDatabase db) {
		CreateAccountPortal portal = new CreateAccountPortal(db);
		String username, password; 
		boolean accountCreated = false; 
		
		while (!accountCreated) {
			System.out.println("Please enter your username: ");
			username = scanner.nextLine(); 
			System.out.println("Please enter your password: ");
			password = scanner.nextLine(); 
			
			if (username.length() < 5 || username.length() < 5) {
				System.out.println("Username and password must be at least 5 characters");
			} else {
				if (portal.createAccount(username, password)) {
					System.out.println("Account created");
					accountCreated = true;
				} else {
					System.out.println("Account already exists");
				}
			}
		}
		System.out.println("You will now be transfered to the login portal");
		login(scanner, db); 
	}
	
	public static void accountPortal(Scanner scanner, UserDatabase db) {
		boolean loggedOut = false; 
		
		while (!loggedOut) {
			
		}
	}
}
