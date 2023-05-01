package TerminalUI;

import java.util.Scanner;

import inventoryManagement.ItemList;

public class PharmacistSession extends UserSession{
	public void pharmacistActive(Scanner scan, Float currentPrice, ItemList Inventory) {
		while(true) {
			System.out.println();
			System.out.println("Functions:\nScanItem\nLogout");
			String userInput = scan.nextLine();
			if(userInput.startsWith("ScanItem")){
				System.out.println("Give Item ID");
				Integer ID = Integer.valueOf(scan.nextLine());
				currentPrice = Inventory.ScanItem(ID, currentPrice);
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
