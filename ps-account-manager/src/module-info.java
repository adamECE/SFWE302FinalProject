module com.pharmacy.account.manager {
	exports com.pharmacy.account.manager; 
	requires com.pharmacy.inventory.manager; 
	uses com.pharmacy.inventory.manager.InventoryDatabase;
	uses com.pharmacy.inventory.manager.Item;
}