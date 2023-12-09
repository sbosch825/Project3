import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Product {
	private static ArrayList<Product> productList = new ArrayList<>(); // array of product list
	private static int numberOfProducts = 0;
    private String name;
    protected double price;
    private char type;
    
    
    public Product(String name, double price, char type) { // Product Object
        this.name = name;
        this.price = price;
       
        this.type = type;
        numberOfProducts++;
    }
    
    public static int getNumberOfProducts() {
        return numberOfProducts;
    }
    
    /**
     *  The getName returns the name of the item.
     * 
     *
     * @return The name of the item.
     */
	
	public String getName() {
		
		return name;
	}
	
	/**
     *  The getPrice returns the price of the item.
     *
     * @return The price of the item.
     */
	
	public double getPrice() {
		
		return price;
	}
	
	
	/**
     *  The getType returns the type of product it is.
     * 
     *
     * @return The type of the item.
     */
	
	public char getType() {
		
		return type;
	}
	
	
	/**
     *  The toString returns the String of each item.
     * 
     * @param None
     *
     * @return The format in strings.
     */
	public String toString() {
		 return "Name: " + name + " Price: " + price + " Type: " + type;
    }
    
    
    /**
     *  The countItems counts the number of items in the text file.
     * 
     * @param inventory
     *            The array of the inventory of the text file
     * 
     * @return The number of items
     */
   public static int countItems(Product[] inventory) {
		 int count = 0;
	        for (Product item : inventory) {
	            if (item != null) {
	                count++;
	            }
	        }
	        return count;
    }//end of countItems

    /**
     *  The findItem binary searches the text file for the matching name of the user input, case-sensitive.
     * 
     * @param inventory
     *            The array of the inventory of the text file
     * @param itemCount
     * 			  The number of items in the inventory
     *@param name
     *			The name of the item inputted by the user
     *
     * @return Null
     */
   public static Product findItem(Product[] inventory, int itemCount, String name) { //uses binary search to return info of desired item
        int left = 0;
        int right = itemCount - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compare = inventory[mid].getName().compareTo(name);
            if (compare == 0) {
                return inventory[mid]; // Found the item
            }
            if (compare < 0) {
                left = mid + 1; // Item may be in the right half
            } else {
                right = mid - 1; // Item may be in the left half
            }
        }
        return null; // Item not found
    } // end of findItem


   /**
    *  The total method returns the price based on quantity bought
    * 
    * @param units
    *            The quantity of units bought
    * @param date
    * 			  The date of the year
    *
    * @return price * units
    */
    public double total(int units, String date) {
        
        return price * units;
    }
    
    /**
     *  The readInventoryFromFile scans the text file.
     * 
     * @param fileName
     *            The name of the text file
     *
     * @return None
     */
    public static Product[] readInventoryFromFile(String fileName) {
        
    	
        
		Product[] inventory = new Product[100]; // Array to store inventory items
		    int itemCount = 0; // Actual number of inventory items

		    try {	//method to read data from text file
		        File file = new File(fileName); 
		        Scanner scanner = new Scanner(file);

		        while (scanner.hasNextLine() && itemCount < 100) {
		            String line = scanner.nextLine();
		            String[] parts = line.split(",\\s+"); // Splits the line using the comma found in the data file
		            if (parts.length == 3) {
		                String name = parts[0];
		                double price = Double.parseDouble(parts[1]);
		                char type = parts[2].charAt(0);
		                switch (type) {
	                    case 'R':
	                        productList.add(new ProductR(name, price, type)); 
	                        break;
	                    case 'B':
	                        productList.add(new ProductB(name, price, type));
	                        break;
	                    case 'S':
	                        productList.add(new ProductS(name, price, type));
	                        break;
	                    default:
	                        break;
	                }
		                Product item = new Product(name, price, type);
		                inventory[itemCount] = item;
		                itemCount++;
		            }
		        }

		        scanner.close();
		    	} catch (FileNotFoundException e) {
		    			e.printStackTrace();
		    		}

		    return inventory;
		
   }//end of readInventoryFromFile
    
    
    /**
     *  The showInventory outputs the text file.
     * 
     * @param inventory
     *            The array of the inventory of the text file
     * @param itemCount
     * 			  The number of items in the inventory
     *
     * @return None
     */
    public static void showInventory(Product[] inventory, int itemCount) {
		  
        for (int i = 0; i < itemCount; i++) {  // for loop to output data from text file
            System.out.println(inventory[i] + "\n");
        }
        
   }//end of showInventory
  
    
    

}//end of Product class
