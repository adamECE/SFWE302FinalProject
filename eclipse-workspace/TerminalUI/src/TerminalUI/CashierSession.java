package TerminalUI;

import java.util.Scanner;

import CheckoutSystem.Cart;
import inventoryManagement.ItemList;

public class CashierSession {
	public void cashierActive(Scanner scan, Float currentPrice, ItemList Inventory) {
		while(true) {
			Cart cart = new Cart();
			System.out.println();
			System.out.println("Functions:\nScanItem\nLogout");
			String userInput = scan.nextLine();
			if(userInput.startsWith("ScanItem")){
				System.out.println("Give Item ID");
				Integer ID = Integer.valueOf(scan.nextLine());
				cart.ScanItem(Inventory, ID);
			}
			else if(userInput.startsWith("Logout")) {
				break;
			}
			else {
				System.out.println("Invalid Input");
			}
		}
	}
}
