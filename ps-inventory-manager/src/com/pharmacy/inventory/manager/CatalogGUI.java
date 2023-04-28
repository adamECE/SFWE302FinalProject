package com.pharmacy.inventory.manager;

import java.util.ArrayList;

public class CatalogGUI {
	public static void displayAllItems(InventoryDatabase database) {
		ArrayList<String> allItems = database.getAllItemsDescription(); 
		for(String s: allItems) {
			System.out.println(s);
		}
	}
}
