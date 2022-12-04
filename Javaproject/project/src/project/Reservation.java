package project;


public class Reservation {
	 //id of the reservation
	private int day; //days for which it is reserved
	public Accomodation accomo;
	
	//constructor
	public Reservation ( int days, Accomodation accom) { //constructor
	
		day = days;
		accomo = accom;
	}
	
	//getters and setters
	
	
	public int getdays() {
		return day;
	}
	
	public void setdays(int x) {
		day=x;
	}
	public Accomodation get_accomo() {
		return accomo ;
	}
	//method to see if an accommodation has a barbacue or not
	public boolean accomHasBarbacue() {
		return accomo.HasBarbacue();
	}
	
	//method toString to show all the information
	public String toString() {
		return accomo.toString() + "ID: "+ accomo.getid() + " number of days: " + day;
	}

}
