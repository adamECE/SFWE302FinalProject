package TerminalUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import UserManagement.User;
import inventoryManagement.Item;
import inventoryManagement.ItemList;

public class ManagerSession extends UserSession {
	UserSession US;
	public void managerActive(Scanner scan, ItemList Inventory, ArrayList<User> UserList) throws IOException {
		while(true) {
			System.out.println();
			System.out.println("Functions:\nAddItem\nCheckItem\nCreateUserAccount\nLogout");
			String userInput = scan.nextLine();
			if(userInput.startsWith("AddItem")) {
				Item newItem = new Item();
				System.out.println("Give Item ID");
				newItem.ID = Integer.valueOf(scan.nextLine());
				System.out.println("Give Item Name");
				newItem.name = scan.nextLine();
				System.out.println("Give Item Expiration Date");
				newItem.expirationDate = Float.parseFloat(scan.nextLine());
				System.out.println("Give Item Quantity");
				newItem.quantity = Integer.valueOf(scan.nextLine());
				System.out.println("Give Item Price");
				newItem.price = Float.parseFloat(scan.nextLine());
			}

			else if (userInput.startsWith("CheckItem")) {
				System.out.println("Give Item Name");
				String name = scan.nextLine();
				Inventory.CheckInventory(name);
			}
			else if (userInput.startsWith("CreateUserAccount")) {
				System.out.println("Enter User's Full Name");
				String name = scan.nextLine();
				System.out.println("Enter User Name");
				String userName = scan.nextLine();
				System.out.println("Enter Password");
				String password = scan.nextLine();
				System.out.println("Enter Account Type, 1 for manager, 2 for pharmacist, 3 for cashier");
				Integer acTy = Integer.valueOf(scan.nextLine());
				User.CreateAccount(password, userName, name, acTy, UserList);
			}
			else if(userInput.startsWith("Logout")) {
				break;
			}
			else {
				System.out.println("Invalid Input");
			}
				
			}
		scan.close();
		}
	}
	