package CheckoutSystem;

import java.util.ArrayList;

public class Invoice {
	ArrayList<String> items;
	Float totalCost;
	
	Invoice(Cart cart) {
		this.items = new ArrayList<String>();
		for(int i = 0; i < cart.items.size(); i++) {
			this.items.set(i, i + " " + cart.items.get(i).name + " " + cart.items.get(i).price);
		}
		this.totalCost = cart.currentPrice;
	}
	public void PrintInvoice(){
		System.out.println("INVOICE");
		System.out.println();
		for(int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i));
			System.out.println();
		}
		System.out.println();
		System.out.println("Total Cost: " + totalCost);
	}
	
}
