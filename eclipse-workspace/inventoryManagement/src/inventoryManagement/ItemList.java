package inventoryManagement;

import java.util.Hashtable;
import java.util.ArrayList;
import java.io.BufferedReader;  
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 


public class ItemList{
	public Float Date;
	public ArrayList<String> nameList;
	public Hashtable<String, ArrayList<Item>> quantityList = new Hashtable<String, ArrayList<Item>>();
	public Hashtable<Integer, Item> itemList = new Hashtable<Integer, Item>(); 
	public int total;
	public boolean AddItem(Item newItem, boolean isLoading) throws IOException{
		boolean newOrNot = false;
		if(nameList.contains(newItem.name)) {
			quantityList.get(newItem.name).add(newItem);
			newOrNot = false;
		}
		else {
			nameList.add(newItem.name);
			ArrayList<Item> items = new ArrayList<Item>();
			items.add(newItem);
			quantityList.put(newItem.name, items);
			newOrNot = true;
		}
		itemList.put(newItem.ID, newItem);
		if(!isLoading) {
			BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv", true));
			writer.append(newItem.ID + "," + newItem.name + ","+ newItem.expirationDate + "," + newItem.quantity + "," + newItem.price);
			writer.close();
		}
		return newOrNot;
	}
	public Item ScanItem(Integer ID) {
		if(itemList.containsKey(ID) && itemList.get(ID).expirationDate >= Date) {
			itemList.get(ID).quantity--;
			System.out.println(ID + " " + itemList.get(ID).name + " $" + itemList.get(ID).price);
			return itemList.get(ID);
		}
		else if(itemList.containsKey(ID) && itemList.get(ID).expirationDate < Date) {
			System.out.println("Item out of Date");
		}
		else {
			System.out.println("Invalid Item, Try Again");
		}
		return null;
	}
	public void CheckInventory(String name) {
		total = 0;
		if(nameList.contains(name)){
			itemList.forEach((ID, itemIndex) ->print(itemIndex, name));
			System.out.println("Total Quantity: " + total);
		}
		else {
			System.out.println("Invalid Medicine Name");
		}
	}
	public void print(Item itemIndex, String name) {
		if(itemIndex.name.startsWith(name)) {
			System.out.println(itemIndex.ID + " " + name + " Quantity: " + itemIndex.quantity + " Exp Date: " + itemIndex.expirationDate);
			total += itemIndex.quantity;
		}
	}
	public ItemList LoadInventory(ItemList inventory) {
		String line = "";  
		String splitBy = ",";
		
		try   
		{  
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));  
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				String[] Item = line.split(splitBy);    // use comma as separator  
				Item newItem = new Item(Integer.valueOf(Item[0]), Item[1], Float.parseFloat(Item[2]), Integer.valueOf(Item[3]), Float.parseFloat(Item[4]));
				inventory.AddItem(newItem, true);
			}
			
			br.close();
			return inventory;
		}   
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}  
		return inventory;
	}	
}