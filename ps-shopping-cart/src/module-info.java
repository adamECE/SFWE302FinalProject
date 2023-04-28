module com.pharmacy.shopping.cart {
	exports com.pharmacy.shopping.cart;
	requires com.pharmacy.inventory.manager; 
	uses com.pharmacy.inventory.manager.InventoryDatabase; 
	uses com.pharmacy.inventory.manager.InventoryMessageInterface;
	uses com.pharmacy.inventory.manager.InventoryReportGenerator;
	uses com.pharmacy.inventory.manager.Item;
	uses com.pharmacy.inventory.manager.ModifyInventoryHandler;
}