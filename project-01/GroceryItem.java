/**
 * 1/21/2021
 * This class represents individual grocery items with name, price, and quantity
 * @author Kean Jaycox
 * 
 */
import java.text.DecimalFormat;
public class GroceryItem {

	private String name;
	private double price;
	private int quantity;
	
	/**
	 * @param name name of grocery item
	 * @param price price of grocery item
	 * @param qty quantity of grocery item
	 */
	public GroceryItem(String name, double price, int qty) {
		this.name = name;
		this.price = price;
		this.quantity = qty;
	}
	
	/**
	 * @return the name of grocery item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the price of grocery item
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @return the quantity of grocery item
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * @param name of grocery item
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param price of grocery item
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * @param quantity of grocery item
	 */
	public void setQuantity(int qty) {
		this.quantity = qty;
	}
	
	/**
	 * @param o object of type GroceryItem
	 * @return boolean of comparison between two GroceryItem names
	 */
	public boolean equals(Object o) {
		if(o instanceof GroceryItem) {
			GroceryItem otherItem = (GroceryItem) o;
			return this.name.equalsIgnoreCase(otherItem.name);
		}
		return false;
	}
	
	/**
	 * @return well formatted properties of GroceryItem
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("$##0.00");
		return name+"\t\t"+df.format(price)+"\t\t"+quantity+"\t"+df.format(price*quantity);
	}
}
