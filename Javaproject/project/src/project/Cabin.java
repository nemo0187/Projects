package project;


public class Cabin extends Accomodation{
	private int numBedrooms;
	private boolean wiFi;
	
	//constructor
	public Cabin(String iD, int price, int numPeople ,int area,int numRooms , boolean wifi) {
		super(iD,numPeople,price , area);
		numBedrooms = numRooms;
		wiFi = wifi;
	}
	
	//method inherited from the father class Accomodation
	public boolean HasBarbacue() {
		boolean barbacue = true; //cabins always have barbecues
		return barbacue;
	}
		
	//getters and setters
	public int getnumrooms() {
		return numBedrooms;
	}
	
	public void setnumrooms(int x) {
		numBedrooms=x;
	}
	
	public boolean getwifi() {
		return wiFi;
	}
	
	public void setwifi(boolean x) {
		wiFi=x;
	}
	
	//method toString to show all the information
	public String toString() {
		String ss = super.toString() ; 
		return ss + " Number of rooms: " + numBedrooms + "Wifi: " + wiFi;
	}
}

