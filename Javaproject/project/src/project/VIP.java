package project;


public class VIP extends Customers {
	private int vipCard;
	
	//constructor
	public VIP(String nameClient, String idClient, long creditCardClient,  int vipCardNum ,boolean joven) { //constructor
		super(nameClient,idClient,creditCardClient, joven);
		vipCard = vipCardNum;
	}
	
	//getters and setters
	public int getvipCard() {
		return vipCard;
	}
	
	public void setvipcard(int x) {
		vipCard=x;
	}
	
	public double calculateDiscount() {
		double result = 10;
		//we check if the number of reservations is higher than 1, to see if we can apply a discount
		if (nReservations>1) {
			result=result+5;
		}
		return result;
	}
	
	//method toString to show all the information
	public String toString() {
		return super.toString() + "Discount: " + calculateDiscount() + "Number of the VIP card: " + vipCard;
	}
}