package com.pharmacy.inventory.manager;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import com.pharmacy.inventory.manager.InventoryDatabase; 

public class InventoryReportGenerator {
	public static void generateReport(InventoryDatabase database) {
		ArrayList<String> allItems = database.getAllItemsDescription(); 
		for(String s: allItems) {
			System.out.println(s);
		}
	}
	
}
