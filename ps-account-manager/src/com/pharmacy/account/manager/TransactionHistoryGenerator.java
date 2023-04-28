package com.pharmacy.account.manager;

import java.util.ArrayList;

public class TransactionHistoryGenerator {
	UserDatabase db;
	public TransactionHistoryGenerator(UserDatabase db) {
		this.db = db; 
	}
	
	public void displayTransactionHisotry(String username) {
		ArrayList<String> list = db.getUserTransactionHistory(username);
		for(String s: list) {
			System.out.print(s + ", ");
		}
		System.out.println();
	}
}
