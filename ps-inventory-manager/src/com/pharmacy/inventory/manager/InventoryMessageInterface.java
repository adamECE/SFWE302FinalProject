package com.pharmacy.inventory.manager;

public interface InventoryMessageInterface {
	boolean removeDbItem(ModifyInventoryHandler db, Item i);
}
