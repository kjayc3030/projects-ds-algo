/**
 * 1/21/2021
 * This class represents individual shopping carts with customer name,
 * an array of GroceryItems, and a counter of how many items are in the cart
 * @author Kean Jaycox
 *
 */
import java.text.DecimalFormat;
public class ShoppingCart {

	private String customer;
	private GroceryItem[] order;
	private int numItems;
	public static final double TAXRATE = 0.075;
	
	public ShoppingCart() {
		order = new GroceryItem[10];
		this.numItems = 0;
		this.customer = "";
	}
	
	/**
	 * @param name name of grocery shopper
	 * 
	 */
	public ShoppingCart(String name) {
		order = new GroceryItem[10];
		this.numItems = 0;
		this.customer = name;
	}
	
	/**
	 * @param name name of grocery shopper
	 * @param capacity capacity of array of GroceryItems
	 */
	public ShoppingCart(String name, int capacity) {
		order = new GroceryItem[capacity];
		this.numItems = 0;
		this.customer = name;
	}
	
	/**
	 * @param name name of grocery item
	 * @param price price of grocery item
	 * @param quantity quantity of grocery item
	 * @return return true if quantity updated or item added, false if anything else
	 */
	public boolean add(String name, double price, int quantity) {
		int temp = this.find(name);
		if(temp >= 0) {
			this.order[temp].setQuantity(this.order[temp].getQuantity() + quantity);
			return true;
		} else if(this.numItems < this.order.length) {
			this.order[this.numItems] = new GroceryItem(name, price, quantity);
			this.numItems++;
			return true;
		}
		return false;
	}
	
	/**
	 * @param name name of grocery item
	 * @return return int, -1 if not found, otherwise return index of found item
	 */
	public int find(String name) {
		GroceryItem specItem = new GroceryItem(name, 1, 1);
		for(int i=0; i < this.numItems; i++) {
			if(this.order[i].equals(specItem)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * @return cart total without tax
	 */
	public double getTotalBeforeTax() {
		double total = 0;
		for(int i=0; i < this.numItems; i++) {
			total = total + (this.order[i].getPrice() * this.order[i].getQuantity());
		}
		return total;
	}
	
	/**
	 * @param taxRate tax rate (set at 7.5%)
	 * @return amount of tax to pay on cart total
	 */
	public double getTax(double taxRate) {
		return taxRate * getTotalBeforeTax();
	}
	
	/**
	 * @return number of different items in cart, not quantity of each
	 */
	public int getNumGroceryItems() {
		return this.numItems;
	}
	
	/**
	 * @return number of items in cart
	 */
	public int getTotalQuantity() {
		int items = 0;
		for(int i=0; i < this.numItems; i++) {
			items = items + (this.order[i].getQuantity());
		}
		return items;
	}
	
	/**
	 * @return nicely formatted table of cart and totals
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("$##0.00");
		double subTotal = this.getTotalBeforeTax();
		double tax = this.getTax(TAXRATE);
		double grandTotal = subTotal + tax;
		String output =  customer + "\n"
				+ "------------------------------------------------\n"
				+ "Item\t\tPrice\t\tQty\tTotal\n"
				+ "------------------------------------------------\n";
		for(int i=0; i < this.numItems; i++) {
						output += this.order[i].toString() + "\n";
					}
		output += "------------------------------------------------\n"
				+ "Total:\t\t" + df.format(subTotal) + "\n"
				+ "Tax:\t\t" + df.format(tax) + "\n"
				+ "------------------------------------------------\n";
		output +=  "Grand Total:\t" + df.format(grandTotal);
				
		return output;
	
	}
}
