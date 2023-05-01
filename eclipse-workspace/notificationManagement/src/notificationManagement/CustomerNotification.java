package notificationManagement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import CustomerManagement.Customer;
import inventoryManagement.Item;


public class CustomerNotification {
	
	public void sendNotification(Customer customer, Item item) throws IOException {
		String noti = customer.name + "! New Item Available! " + item.name + " has been added to stock!";
		customer.notifications.add(noti);
		BufferedWriter writer = new BufferedWriter(new FileWriter("notifications.txt", true));
		writer.append(noti);
		writer.close();
	}
	public void clearNotifications(Customer customer) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("notifications.txt"));
		writer.write("");
		writer.flush();
		writer.close();
	}
	public Customer LoadNotifications(Customer customer) {
		String line = "";  
		try   
		{  
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader("notifications.txt"));  
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				customer.notifications.add(line);
			}
			
			br.close();
			return customer;
		}   
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}  
		return customer;
	}
}
