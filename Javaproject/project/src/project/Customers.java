package project;


public class Customers {
	protected String name;
	protected String id;
	protected long creditCard;
	protected int nReservations = 0;
	protected boolean vip ; 
	public Reservation[] reser= new Reservation[5];
	
	//constructor
	public Customers(String nameClient, String idClient, long creditCardClient, boolean Type) { //constructor
		name = nameClient;
		id = idClient;
		creditCard = creditCardClient;
		vip = Type ;
	}
	
	//getters and setters
	public String getname() {
		return name;
	}
	
	public void setname(String x) {
		name=x;
	}
	
	public String getid() {
		return id;
	}
	
	public void setid(String x) {
		id=x;
	}
	
	public long getcreditcard() {
		return creditCard;
	}
	
	public void setcreditcard(long x) {
		creditCard=x;
	}
	
	public int get_nReservations() {
		return nReservations;
	}
	
	public void setnreservations(int x) {
		nReservations=x;
	}
	
	//we add a reservation if the number of reservations is lower than 5
	public void addReserv(int numDays, Accomodation acco, Customers idClient) { 
		if (idClient.nReservations<5) {
		reser[idClient.nReservations]= new Reservation( numDays, acco) ;
		nReservations++ ; 
		} else {
			System.out.println("you cant have more reservations") ; 
		}
		
	}
	
	//method to check if we can apply a discount
	public int calculateDisc( ) {
		
		//we see if the number of reservations is equal or lower than 1 to know if we can apply the discount
		if (nReservations>=1 && vip == false) { 
			return 5 ; 
		}else if(nReservations>=1 && vip == true) {
			return 10 ;
		} 
		else return 0 ; 
	}
	
	//we show the reservations a certain client has
	public String consultReservation(String id) {
		String cadena = " ";
		if (nReservations==0) {
			cadena = "  ";
		} else {
			for(int i=0;i<nReservations;i++) {
				cadena+=reser[i].toString();
			}
		}
		return cadena;
	}
	
	//we show on the screen if a certain reservation has a barbecue
	public String consultBBQ() { 
		String cadena = " ";
		if (nReservations==0) {
			cadena = " You have no reservations  ";
		} else {
			for(int i=0;i<nReservations;i++) {
				cadena=reser[i].toString();
				if(reser[i].accomHasBarbacue()) {
					cadena = " It has barbecue. ";
				}
			}
		}
		return cadena;
	}
	
	
	public  Reservation get_reser(int i) {
		return reser[i] ; 
	}
	//method toString to show all the information
	public String toString() {
		return "The client with name " + name + " with ID " + id + " has a total of " + nReservations +" Reservations"; 
	}
}
