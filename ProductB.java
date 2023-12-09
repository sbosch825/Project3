public class ProductB extends Product {
	
	    public ProductB(String name, double price, char type) { 
	    	
	        super(name, price, 'B');
	    }

	  
	    public double total(int units, String date) {
	    	double discount = price;

	        if (units >= 100 && units < 500) {
	            discount = price * 0.95; // 5% discount given
	        } else if (units >= 500 && units < 1500) {
	            discount = price * 0.85; // 15% discount given
	        } else if (units >= 1500) {
	            discount = price * 0.75; // 25% discount given
	        }

	        return discount * units;

	    }
	
}// end of ProductB class