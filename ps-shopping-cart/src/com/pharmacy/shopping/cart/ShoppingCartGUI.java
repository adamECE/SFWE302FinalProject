package com.pharmacy.shopping.cart;

import java.util.ArrayList;
import java.util.Scanner;

import com.pharmacy.inventory.manager.InventoryDatabase;
import com.pharmacy.inventory.manager.ModifyInventoryHandler;



public class ShoppingCartGUI {
	final static int EXPIRED_RETURN_CODE = -1; 
	final static int ERROR_RETURN_CODE   = 0; 
	final static int SUCCESS_RETURN_CODE = 1; 
	
	public static void main(String[] args) {
		// initialize data 
		boolean checkoutCanceled; 
		
		InventoryDatabase db = new InventoryDatabase(); 
		initDB(db); 
		ModifyInventoryHandler handler = new ModifyInventoryHandler(db); 
		
		checkoutCanceled = checkoutMainLoop(db, handler); 
		
		if (checkoutCanceled)
			System.out.println("Checkout has been canceled");
		else 
			System.out.println("You have sucessfully checked out");
	}
	
	// For testing purposes, generates a random database. 
	public static void initDB(InventoryDatabase db) {
		db.addInventoryItem("Cough Medicine", 123, 15, 12232026, "Good for coughs, take once a day.");
		db.addInventoryItem("Cough Medicine", 213, 15, 12232025, "Good for coughs, take once a day.");
		db.addInventoryItem("Cough Medicine", 345, 15, 12232024, "Good for coughs, take once a day.");
		db.addInventoryItem("Expired Item",   512, 20, 3232000,  "This item is beyond expired.");
	}
	
	public static int getTodaysDate() {
		// returning a dummy variable for now. 
		return 10102016;
	}
	
	public static void printDB_Items(InventoryDatabase db) {
		ArrayList<String> allItemDesc = db.getAllItemsDescription();
		for(String s: allItemDesc) {
			System.out.println(s);
		}
	}
	
	public static boolean checkoutMainLoop(InventoryDatabase db, 
			ModifyInventoryHandler handler) {
		Scanner scanner = new Scanner(System.in); 
		ShoppingCart cart = new ShoppingCart(db); 
		int todaysDate = getTodaysDate();
		
		// main loop variables 
		boolean checkoutIsOver = false; 
		String name = "", continueScanning = "", strID; 
		int id = -1;
		
		System.out.println("Welcome to the Pharamcy Checkout");

		
		while (!checkoutIsOver) {
			System.out.println("Here are our provided items:\n");
			printDB_Items(db);
			System.out.println();
			
			System.out.println("Please enter the name of the item you wish to purcahase: ");
			name = scanner.nextLine();
			System.out.println("Please enter the id [number in brackets] of the item you wish to purcahase: ");
			strID = scanner.nextLine();
			id = Integer.parseInt(strID);
			
			int returnCode = cart.addItem(name, id, todaysDate);
			if (returnCode == EXPIRED_RETURN_CODE) {
				System.out.println("Item is expired, could not process request");
			} else if (returnCode == ERROR_RETURN_CODE) {
				System.out.println("There was an error processing this item");
			} 
			
			System.out.println("\nYour current cart is: ");
			cart.printCart();
			
			System.out.println("Would you like to add another item(yes/no)?");
			continueScanning = scanner.nextLine();
			if (continueScanning.equals("no")) 
				checkoutIsOver = true; 	
		}
		
		// user checks out 
		Checkout checkout = new Checkout(cart, handler); 
		double price = checkout.checkout();
		
		if (price == 0) 
			return false; 
		
		System.out.println("The price of your order is $" + price);
		System.out.println("Not really sure how to simulate a payment, but that would happen here");
		
		// Ideally would call banking API here but that is outside the scope of this assignment
		
		return true; 
	}

}
