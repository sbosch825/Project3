class Date {
	    private int month;
	    private int day;
	    private int year;

	    public Date(String date) {
	       
	        this.month = 1;
	        this.day = 1;
	        this.year = 2023;
	    }

	   
	    public String toString() {
	        return month + "/" + day + "/" + year;// returns the string format of the date.
	    }
	}// end of Date class