package com.pharmacy.inventory.manager;

public class ModifyInventoryHandler {
	private InventoryDatabase db; 
	public ModifyInventoryHandler(InventoryDatabase database) {
		db = database; 
	}
	
	public void addInventoryItem(String name, int id,  
			double price, int experationDate, String description) {
		db.addInventoryItem(name, id, price, experationDate, description); 
	}
	
	public boolean removeInventoryItem(String name, int id) {
		return db.removeInventoryItem(name, id); 
	}
	
}
