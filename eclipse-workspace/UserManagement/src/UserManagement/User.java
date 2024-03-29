package UserManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class User{
	String password;
	String userName;
	String name;
	Integer AccountType; // 1 is manager, 2 is pharmacist, 3 is cashier
	
	User(String pW, String uN, String n, Integer a){
		 password = pW;
		 userName = uN;
		 name = n;
		 AccountType = a;
	}
	public User() {
		password = null;
		userName = null;
		name = null;
		AccountType = null;
	}
	public Integer login(ArrayList<User> UserList, Scanner scan){
		
		while(true) {
			System.out.println("Enter User Name");
			String userInput = scan.nextLine();
			System.out.println("Enter Password");
			String passInput = scan.nextLine();
			for(int i = 0; i < UserList.size(); i++) {
				if(userInput.startsWith(UserList.get(i).userName)) {
					if(passInput.startsWith(UserList.get(i).password)){
						System.out.println("Welcome, " + UserList.get(i).name);
						return UserList.get(i).AccountType;
					}
				}
			}
			System.out.println("Incorrect, try again? (y/n)");
			if(scan.nextLine().startsWith("n")) {
				break;
			}
		}
		return -1;
	}
	public static void CreateAccount(String pW, String uN, String n, Integer a, ArrayList<User> UserList) throws IOException {
		User newUser = new User(pW, uN, n, a);
		UserList.add(newUser);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("userDB.csv", true));
		try {
			writer.append(n + "," + uN + "," + pW + "," + a);
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.close();
	}
	public static ArrayList<User> LoadUserList() {
		String line = "";  
		String splitBy = ",";
		ArrayList<User> UserList = new ArrayList<User>(); 
		try   
		{  
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader("userDB.csv"));  
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				String[] User = line.split(splitBy);    // use comma as separator  
				User newUser = new User(User[2], User[1], User[0], Integer.valueOf(User[3]));
				UserList.add(newUser);
			}
			
			br.close();
			return UserList;
		}   
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}  
		return UserList;
	}
}