package inventoryManagement;

public class Item{
	public Integer ID;
	public String name;
	public Integer quantity;
	public float expirationDate;
	public float price;
	public Item(Integer identify, String itemName, float expDate, Integer number, float cost) {
		this.ID = identify;
		this.name = itemName;
		this.quantity = number;
		this.expirationDate = expDate;
		this.price = cost;
	}
	public Item() {
		this.expirationDate = 0;
		this.ID = 0;
		this.name = "empty";
		this.price = 0;
		this.quantity = 0;
	}
}
