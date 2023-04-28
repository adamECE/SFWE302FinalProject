package com.pharmacy.shopping.cart;

import java.util.ArrayList;

import com.pharmacy.inventory.manager.InventoryDatabase;
import com.pharmacy.inventory.manager.Item;
import com.pharmacy.inventory.manager.ModifyInventoryHandler;

public class Checkout {
	private ShoppingCart cart; 
	private ModifyInventoryHandler db;
	
	public Checkout(ShoppingCart cart, ModifyInventoryHandler db) {
		this.cart = cart; 
		this.db = db; 
	}
	public double checkout() {
		ArrayList<Item> items = cart.getItems(); 
		double price = 0;
		InventoryMessageHandler handler = new InventoryMessageHandler(); 
		for(Item i: items) {
			price += i.getPrice(); 
			handler.removeDbItem(db, i); 
		}
		
		return price; 
	}
}
