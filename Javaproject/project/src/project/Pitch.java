package project;


public class Pitch extends Accomodation{
	private boolean campervan;
	private boolean barbacue;
	
	//constructor
	public Pitch (String iD, int price, int numPeople,int area, boolean campervans, boolean barbacues) { //constructor
		super(iD,numPeople,price ,area);
		campervan = campervans;
		barbacue = barbacues;
	}
	
	//method inherited from the father class Accomodation, acts like a getter
	public boolean HasBarbacue(){
		return barbacue;
	}
	
	//getters and setters
	public boolean getcampervan() {
		return campervan;
	}
	
	public void setcampervan(boolean x) {
		campervan=x;
	}
	
	public void setbarbacue(boolean x) {
		barbacue=x;
	}
	
	//method toString to show all the information
	public String toString() {
		String ss = super.toString() ; 
		return ss + "Campervans: " + campervan + " Barbecue: " + barbacue;
	}
}

