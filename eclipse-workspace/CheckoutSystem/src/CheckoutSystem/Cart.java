package CheckoutSystem;

import java.util.ArrayList;
import java.util.Scanner;

import inventoryManagement.Item;
import inventoryManagement.ItemList;

public class Cart {
	ArrayList<Item> items;
	Float currentPrice = (float) 0.0;
	
	public void Checkout(ItemList Inventory, Scanner scan) {
		int i = 0;
		do {
			System.out.println("Give Item ID");
			Integer ID = Integer.valueOf(scan.nextLine());
			
			ScanItem(Inventory, ID, i);
			System.out.println("More Items to Scan? (y/n)");
			i++;
		}while(scan.nextLine().startsWith("y"));
		Invoice invoice = new Invoice(this);
		
	}
	public void ScanItem(ItemList Inventory, Integer ID, int i) {
		this.items.set(i, Inventory.ScanItem(ID));
	}
}