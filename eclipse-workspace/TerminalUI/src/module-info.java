/**
 * 
 */
/**
 * @author pymda
 *
 */
module main.app {
	requires UserManagement;
	requires CustomerManagement;
	requires inventoryManagement;
	requires CheckoutSystem;
	uses inventoryManagement.Item;
}