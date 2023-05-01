package CustomerManagement;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	public void createAccount(Scanner scan) {
		
	}
}