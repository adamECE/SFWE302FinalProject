package com.pharmacy.shopping.cart;

import java.util.ArrayList;
import com.pharmacy.inventory.manager.*;

public class ShoppingCart {
	private ArrayList<Item> items; 
	private InventoryDatabase db; 
	private int EXPIRED_RETURN_CODE = -1; 
	private int ERROR_RETURN_CODE = 0; 
	private int SUCCESS_RETURN_CODE = 1; 
	
	public ShoppingCart(InventoryDatabase database) {
		items = new ArrayList<Item>(); 
		db = database; 
	}
	
	public ArrayList<Item> getItems(){
		return items; 
	}
	
	public int addItem(String name, int id, int todaysDate) {
		ArrayList<String> expired = db.getExpiredList(todaysDate); 
		if(expired.contains(name)) {
			return EXPIRED_RETURN_CODE; 
		} else {
			Item item = db.getItem(name, id);
			if (item != null) {
				items.add(item);
				return SUCCESS_RETURN_CODE; 
			} else {
				return ERROR_RETURN_CODE; 
			}
				
		}
	}
	
	public void printCart() {
		double totalPrice = 0;
		
		if(items.size() != 0) {
			for(Item item: items) {
				System.out.println("$" + item.getPrice() + " " + item.getName());
				totalPrice += item.getPrice(); 
			}
			System.out.println("Current Total Price is " + totalPrice);
		} else {
			System.out.println("Cart is empty.");
		}
	}
}
