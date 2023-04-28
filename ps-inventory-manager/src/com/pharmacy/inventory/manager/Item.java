package com.pharmacy.inventory.manager;

public class Item {
	private String name, description;
	int id, experationDate; 
	private double price;
	
	public Item(String name, double price, 
			int experationDate, String description, int id) {
		this.name = name;
		this.price = price; 
		this.id = id; 
		this.experationDate = experationDate; 
		this.description = description; 
	}
	
	public void setDescription(String desc) {
		description = desc; 
	}
	
	public String getName() {
		return name; 
	}
	
	public String getDescription() {
		return description; 
	}
	
	public double getPrice() {
		return price; 
	}
	
	public int getId() {
		return id; 
	}
	
	public int getExperationDate() {
		return experationDate; 
	}
	
	public String getParsedExperationDate() {
		String parsedDate = ""; 
		int tempExp = experationDate; 
		
		parsedDate += Integer.toString(tempExp%10000);
		tempExp /= 10000; 
		parsedDate = Integer.toString(tempExp%100)+ "/" + parsedDate; 
		tempExp /= 100;
		parsedDate = Integer.toString(tempExp)+ "/" + parsedDate;
		return parsedDate; 
	}
	
	public String getItemDescription() {
		return name + ":" + description + "\nPrice: " + price +
				". Expires: " + experationDate;
	}
	
}
