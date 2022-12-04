package project;


public abstract class Accomodation {
	protected char type ; 
	protected String id;
	protected int numOfPeople;
	protected int pricePerNight;
	protected int area ; 
	private boolean available;
	
	//constructor
	public Accomodation() {
	  id = "A" ; 
	  numOfPeople = 0 ; 
	  pricePerNight = 0 ; 
	  area = 0 ; 
	  available = false ; 
	}
	public Accomodation(String iD, int numPeople, int price , int area1) {
		id = iD;
		numOfPeople = numPeople;
		pricePerNight = price;
		area = area1 ; 
		available = true;
		type = id.charAt(0) ; 
	}
	
	//getters and setters
	public String getid() {
		return id;
	}
	
	public void setid(String x) {
		id=x;
	}
	
	public int getnumofpeople() {
		return numOfPeople;
	}
	
	public void setnumofpeople(int x) {
		numOfPeople=x;
	}
	
	public int getpricepernight() {
		return pricePerNight;
	}
	
	public void setpricepernight(int x) {
		pricePerNight=x;
	}
	public int getArea() {
		return area;
	}
	
	public void setArea(int x) {
		area=x;
	}
	
	public boolean getifavailable() {
		return available;
	}
	
	public void setavailable(boolean x) {
		available=x;
	}
	
	public abstract boolean HasBarbacue(); //the body of this method will be implemented in child classes (Pitch and Cabin)
	
	//method toString to show all the information
	public String toString() {
			return "The accomodation with ID " + id + " can have up to " + numOfPeople + " Person per Night and has a price per night of " + pricePerNight + " € and area is : "+area;
	}
}

