package com.pharmacy.shopping.cart;

import com.pharmacy.inventory.manager.InventoryMessageInterface;
import com.pharmacy.inventory.manager.Item;
import com.pharmacy.inventory.manager.ModifyInventoryHandler;

public class InventoryMessageHandler implements InventoryMessageInterface{

	@Override
	public boolean removeDbItem(ModifyInventoryHandler db, Item i) {
		return db.removeInventoryItem(i.getName(), i.getId());
	}

}
