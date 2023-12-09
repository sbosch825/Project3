/* ICSI 201 -Introduction to Computer Science
 * Fall 2023
 * CSI 201- 8878
 * Samantha Bosch
 * SB764845
 * sbosch@albany.edu
 * 
 * This project will ask the user to choose from the menu to place and review orders from the given inventory.
 * Test Data Used:
 *< i I E q> 
 *<Hammer Wrench Crayon>
 *< 0 10 -1>
 *<12/03/2020, 02/28/2016, 11/11/2015>
 *
 *
 *
*/
import java.io.IOException;

import java.util.Scanner;

public class P3Driver_SB764845 {
	
	
	public static void main(String[] args)throws IOException {
		
		Product[] inventory = Product.readInventoryFromFile("Items.txt"); // Created an object from the Item class
		int itemCount = Product.countItems(inventory); // the data from the text file
	    boolean exit = false; 
		Scanner keyboard = new Scanner(System.in); // scanner to get user input
		char choice; 
		 
		while(!exit) { //while loop to repeat menu options until user decides to quit
			printMenu();
			choice = keyboard.next().charAt(0);
		 
		
			switch(choice) {
			case 'I','i':
			 		Product.showInventory(inventory, itemCount); // shows inventory
			 		break;
			 		
			case 'O', 'o':
				
			Order.makeOrder(keyboard); // calls the makeOrder method from Order class
			 		break;
			case 'R', 'r':
				
				Order.reviewOrders(); // calls the reviewOrders method from Order class
			 		break;
			 		
			case 'E', 'e':
				
				Order.saveOrdersToFile(); // adds the order to the array of order lists
				
			System.out.println("Goodbye!");
				exit = true;
			 		break;
			default:
				System.out.println("Invalid choice. Please try again."); //when user inputs incorrect response
				break;
			}
		 
	 
		}
			keyboard.close();
	
}
	// Method used to create menu
	public static void printMenu()
		{
			System.out.println( "(I)nventory \n" 	
					+ "(O)rder \n"	
					+ "(R)eview the Order \n"
					+ "(E)xit \n"
						);
		}
	

	


}//end of driver file

