package com.pharmacy.account.manager;

public class CreateAccountPortal {
	UserDatabase db;
	public CreateAccountPortal(UserDatabase db) {
		this.db = db; 
	}
	
	public boolean createAccount(String username, String password) {
		return db.addUser(username, password);
	}
}
