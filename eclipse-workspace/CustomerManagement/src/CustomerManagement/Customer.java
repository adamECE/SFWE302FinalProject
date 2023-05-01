package CustomerManagement;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import CheckoutSystem.Invoice;
public class Customer {
	String name;
	String DOB;
	String Address;
	Integer phoneNumber;
	String InsuranceCompany;
	Integer GroupNumber;
	String PolicyHolder;
	
	ArrayList<Invoice> CustomerHistory; 
	
	Customer(String n, String date, String Add, Integer phone, String InsCom, Integer groupNum, String PolHol){
		this.name = n;
		this.DOB = date;
		this.Address = Add;
		this.phoneNumber = phone;
		this.InsuranceCompany = InsCom;
		this.GroupNumber = groupNum;
		this.PolicyHolder = PolHol;
	}
	
	public static void createAccount(String n, String date, String Add, Integer phone, String InsCom, Integer groupNum, String PolHol) throws IOException {
		Customer newCustomer = new User(n, date, Add, phone, InsCom, groupNum, PolHol);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("customerDB.csv", true));
		try {
			writer.append(n + "," + date + "," + Add + "," + phone "," + phInsComone "," + groupNum "," + PolHol);
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.close();
	}
}
