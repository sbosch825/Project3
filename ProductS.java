public class ProductS extends Product {
	
	    public ProductS(String name, double price, char type) {
	        super(name, price, 'S');
	        
	    }

	 
	    public double total(int units, String date) {
	    	
	        String[] parts = date.split("/");
	        int month = Integer.parseInt(parts[0]);

	        if (month >= 11 || month <= 2) {  // If month is equal to November or February
	            double total = price * units * 0.6;  // 40% of total
	            return total;
	        } else {
	            return price * units;
	        }
	        	
	      
	       
	    }
	}// end of ProductS class