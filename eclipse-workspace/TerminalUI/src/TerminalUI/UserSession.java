
package TerminalUI;
import java.util.Scanner;

import CustomerManagement.Customer;
import inventoryManagement.Item;
import inventoryManagement.ItemList;
import UserManagement.User;

import java.io.IOException;
import java.util.ArrayList;
public class UserSession {
	public static void main(String[] args) throws IOException{
		User user = new User();
		ArrayList<User> UserList = User.LoadUserList();
		ItemList Inventory = new ItemList();
		Integer view = 0;
		Float currentPrice = (float) 0;
		InitializeSystem(Inventory);
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to main menu!");
		
		view = user.login(UserList, scan);
		if(view == -1) {
			return;
		}
		if(view == 1) {
			ManagerSession ms = new ManagerSession();
			ms.managerActive(scan, Inventory, UserList);
			scan.close();
			}
		else if (view == 2) {
			PharmacistSession ps = new PharmacistSession();
			ps.pharmacistActive(scan, currentPrice, Inventory);
			scan.close();
		}
		else {
			CashierSession cs = new CashierSession();
			cs.cashierActive(scan, currentPrice, Inventory);
			scan.close();
		}
		}
	public static void InitializeSystem(ItemList Inventory) {
		Inventory.Date = (float) 5.1;
		Item first = new Item();
		first.expirationDate = 0;
		first.ID = 0;
		first.name = "empty";
		first.price = 0;
		first.quantity = 0;
		Inventory.itemList.put(0, first);
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(first);
		Inventory.quantityList.put(first.name, list);
		Inventory.nameList = new ArrayList<String>();
		Inventory.nameList.add(first.name);
		Inventory.LoadInventory(Inventory);
		
	}
}
