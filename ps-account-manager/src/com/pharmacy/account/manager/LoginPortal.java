package com.pharmacy.account.manager;

public class LoginPortal {
	UserDatabase db;
	public LoginPortal(UserDatabase db) {
		this.db = db; 
	}
	
	public boolean loginUser(String username, String password) {
		return db.loginUser(username, password);
	}
}
