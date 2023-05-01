/**
 * 
 */
/**
 * @author pymda
 *
 */
module notificationManagement {
	exports notificationManagement;
	requires transitive inventoryManagement;
	requires transitive accountManagement;
	uses CustomerManagement.Customer;
	uses accountManagement.User;
	uses inventoryManagement.ItemList;
	
}