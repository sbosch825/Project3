import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Order {
	

	private static ArrayList<Order> orderList = new ArrayList<>();	// arrays to put complete orders in
	    private Product product;
	    private int quantity;
	    private Date date;

	    public Order(Product product, int quantity, Date date) {
	        this.product = product;
	        this.quantity = quantity;
	        this.date = date;
	    }

	   
	    public String toString() {
	        return "Order Details - " + product.toString() +
	                ", Quantity: " + quantity + ", Order Date: " + date.toString();// returns the string format of the date.
	    }

	    public double getTotalPrice() {
	        return product.total(quantity, date.toString());
	    }
	    
	    
	    /**
	     *  The makeOrder allows user to place an order
	     *  
	     * @param keyboard
	     * 			The user's input
	     *
	     * @return None
	     */
	    public static void makeOrder(Scanner keyboard) {
	    	
	    	
	    	Product[] inventory = Product.readInventoryFromFile("Items.txt"); // Created an object from the Item class
	    	int itemCount = Product.countItems(inventory); // the data from the text file
	    	keyboard.nextLine();  // Consume the newline character
		    System.out.println("Enter the name of the product you want to order:"); //prompts user to enter name of product
	        String nameOfItem = keyboard.nextLine();
	        
	        Product foundItem = Product.findItem(inventory, itemCount, nameOfItem); 
	        if (foundItem != null)	// if statement used to proceed with order if the item is found
	        {
	            System.out.println("Enter the quantity:"); // prompts for quantity
	            int quantity = keyboard.nextInt();
	            keyboard.nextLine(); // consume newline

	            System.out.println("Enter the date of purchase (mm/dd/yyyy):"); //prompts for date
	            String date = keyboard.nextLine();
	            Date orderDate = new Date(date);

	            Order order = new Order(foundItem, quantity, orderDate); // uses the Order object to add into the list of orders
	            orderList.add(order);

	            System.out.println("Order created:");
	            System.out.println(order.toString());
	        } 
	        else {
	            System.out.println("Product not found in the inventory.");
	        }
			
	    	
	    }
	    
	    /**
	     *  The reviewOrders allows user to see previous orders
	     *  
	     * @param None
	     * 
	     *
	     * @return None
	     */
	    public static void reviewOrders() {
	        System.out.println("List of Orders:");
	        for (Order order : orderList) {
	            System.out.println(order.toString());
	            System.out.println("Total Price: $" + order.getTotalPrice());
	            System.out.println();
	        }
	    }
	    
	    /**
	     *  The saveOrdersToFile puts each order into an array in a new text file
	     * 
	     * @param None
	     * 
	     *
	     * @return None
	     */
	    public static void saveOrdersToFile() {
	        try (PrintWriter writer = new PrintWriter(new FileWriter("orders.txt"))) {
	            for (Order order : orderList) {
	                writer.println(order.toString());
	                writer.println("Total Price: $" + order.getTotalPrice());
	                writer.println();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    	  
    
	    
	}// end of Order class