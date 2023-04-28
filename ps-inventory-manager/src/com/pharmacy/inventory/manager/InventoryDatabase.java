package com.pharmacy.inventory.manager;
import java.util.Hashtable;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class InventoryDatabase {
	private Hashtable<String, Hashtable<Integer, Item>> items; 
	
	public InventoryDatabase() {
		items = new Hashtable<String, Hashtable<Integer, Item>>(); 
	}
	
	/*
	 * Adds an item to the inventory database. 
	 * */
	public void addInventoryItem(String name, int id,  
			double price, int experationDate, String description) {
		Item newItem = new Item(name, price, experationDate,  description, id);
		
		if (!items.containsKey(name)) {
			Hashtable<Integer, Item> newItemList = new Hashtable<Integer, Item>(); 
			newItemList.put(id, newItem); 
			items.put(name,newItemList);
		} else {
			Hashtable<Integer, Item> newItemList = items.get(name); 
			newItemList.put(id, newItem); 
		}
	}
	
	
	/*
	 * Removes an item from the inventory
	 * */
	public boolean removeInventoryItem(String name, int id) {
		if(items.remove(name) != null)
			return true; 
		
		return true; 
	}
	
	/*
	 * Removes a single item from the inventory (i.e. for checkout)
	 * */
	public boolean removeItem(String name, int id) {
		if (!items.contains(name))
			return false;
		
		Hashtable<Integer, Item> newItemList = items.get(name); 
		if(!items.contains(id)) 
			return false; 
		
		newItemList.remove(id);
		
		return true; 
	}
	
	/*
	 * Make a list of all expired items. 
	 * */
	public ArrayList<String> getExpiredList(int todaysDate) {
		ArrayList<String> expiredItemList = new ArrayList<String>(); 
		Set<String> itemList = items.keySet();
		
		for(String s: itemList) {
			Hashtable<Integer, Item> curList = items.get(s); 
			Set<Integer> itemsInList = curList.keySet();
			for(int i: itemsInList) {
				Item item = curList.get(i);
				if(item.getExperationDate() < todaysDate) {
					expiredItemList.add(item.getName()); 
				}
			}
		}
		
		return expiredItemList;      
	}
	
	public ArrayList<String> getAllItemsDescription(){
		ArrayList<String> allItemsList = new ArrayList<String>(); 
		Set<String> itemList = items.keySet();
	
		for(String s: itemList) {
			Hashtable<Integer, Item> curList = items.get(s); 
			Set<Integer> itemsInList = curList.keySet();
			for(int i: itemsInList) {
				Item item = curList.get(i);
				allItemsList.add("$" + item.getPrice() +" - "+ item.getName() + " [" + item.getId() + "]: " + item.getDescription() 
								+ " " + item.getParsedExperationDate()); 
				
			}
		}
		
		return allItemsList;   
	}
	
	public Item getItem(String name, int id){
		if (!items.containsKey(name))
			return null; 
		Hashtable<Integer, Item> curList = items.get(name); 
		if (!curList.containsKey(id))
			return null; 
		return curList.get(id); 
	}
	
}
