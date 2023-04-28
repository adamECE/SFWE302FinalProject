package com.pharmacy.account.manager;
import java.util.Hashtable;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class UserDatabase {
	
	private Hashtable<String, User> users; 
	private Set<String> loggedInUsers; 
	
	public UserDatabase() {
		users = new Hashtable<String, User>(); 
		loggedInUsers = new HashSet<String>(); 
	}
	
	/*
	 * Adds a user to the database. 
	 * */
	public boolean addUser(String username, String password) {
		User newUser = new User(username, password); 
		if (users.containsKey(username)) {
			return false;
		}
		users.put(username, newUser);
		return true; 
	}
	
	public ArrayList<String> getUserTransactionHistory(String username){
		if (loggedInUsers.contains(username)) {
			return users.get(username).getPurchasedMedication(); 
		}
		return null; 
	}
	
	/*
	 * Logs the user in 
	 * Returns true if user is successfully logged in. 
	 * */
	public boolean loginUser(String username, String password) {
		User user = users.get(username); 
		if (user != null) {
			if (user.getPassword().equals(password)) {
				loggedInUsers.add(username); 
				return true;
			}
		}
			
		// password was incorrect. 
		return false; 
	}
	
	public boolean checkUserIsLoggedIn(String username) {
		return loggedInUsers.contains(username); 
	}
	
	
	public boolean addSugestedMedication(String username, String medication) {
		if (!checkUserIsLoggedIn(username))
			return false; 
		
		User curUser = users.get(username); 
		curUser.addSugestedMedication(medication);
		return true; 
	}
	
	public boolean addPurchasedMedication(String username, String medication) {
		if (!checkUserIsLoggedIn(username))
			return false; 
		
		User curUser = users.get(username); 
		curUser.addPurchasedMedication(medication);
		return true;
	}
	
	
	private class User {
		private String username, password; 
		private ArrayList<String> suggestedMedication; 
		// purchase history may store an object later. 
		private ArrayList<String> purchaseHistory; 
		
		public User(String username, String password){
			this.username = username; 
			this.password = password; 
		}
		
		public String getPassword() {
			return password; 
		}
		
		public String getUsername() {
			return username; 
		}
		
		public ArrayList<String> getSuggestedMedication() {
			return suggestedMedication;
		}
		
		public ArrayList<String> getPurchasedMedication() {
			return purchaseHistory;
		}
		
		public void addSugestedMedication(String medication) {
			suggestedMedication.add(medication);
		}
		
		public void addPurchasedMedication(String medication) {
			purchaseHistory.add(medication);
		}
	}
}
