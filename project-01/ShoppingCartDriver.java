/**
 * 1/21/2021
 * This class drives GroceryItem and ShoppingCart classes 
 * It creates carts that store grocery items and tests methods from ShoppingCart
 * @author Kean Jaycox
 * 
 */
public class ShoppingCartDriver {

	public static void main(String[] args) {

		ShoppingCart cart01 = new ShoppingCart("Maria Saavadra", 5);		//creates first cart Maria
		ShoppingCart cart02 = new ShoppingCart("Angel Saavadra", 6);		//creates second cart Angel
		
		cart01.add("Beans", 2.50, 3);
		cart01.add("Chips", 4.99, 2);
		cart01.add("Corn", 1.99, 2);
		cart01.add("Soup", 3.75, 4);										//four items for Maria - cart01
		
		cart02.add("Cheese", 3.99, 2);
		cart02.add("Milk", 2.25, 1);
		cart02.add("Bread", 3.25, 2);
		cart02.add("Wine", 18.99, 2);
		cart02.add("Beer", 8.99, 3);
		cart02.add("Tea", 1.99, 3);											//six items for Angel - cart02
		
		System.out.println("Method & other Testing:");
		System.out.println("\tModify cart quantity (want true): " + cart02.add("Cheese", 1.50, 3));		//tests quantity change for Cheese in Angel's cart
		System.out.println("\tCart too full (want false): " + cart02.add("Lettuce", 1.50, 6));			//tests Angel's cart being too full to add
		System.out.println("\tFind works (want zero or pos num): " + cart02.find("beer"));				//tests find method
		System.out.println("\tgetTotalBeforeTax method: " + cart01.getTotalBeforeTax());				//tests getTotalBeforeTax method
		System.out.println("\tgetTax method: " + cart01.getTax(ShoppingCart.TAXRATE));					//tests getTax method
		System.out.println("\tgetNumGroceryItems method: " + cart02.getNumGroceryItems());				//tests getNumGroceryItems method
		System.out.println("\tgetTotalQuantity method: " + cart01.getTotalQuantity());					//tests getTotalQuantity method
		
		
		System.out.println("\n" + cart01.toString() + "\n\n");

		System.out.println(cart02.toString());
	}
}
