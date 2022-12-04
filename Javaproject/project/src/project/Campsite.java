package project;


import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.* ;
class Campsite {
    private Accomodation[] accomo = new Accomodation[12] ; 
    private Customers[] clients = new Customers[200];
    private String Accomodation_txt;
    private static String Clients_txt;
	public Campsite(String str1 , String str2) throws IOException {
		
		Accomodation_txt=str1 ; 
		Clients_txt= str2 ;  
		readACCOMODATION(Accomodation_txt , accomo) ; 
		readClientes(Clients_txt , clients) ; 
	}
	
	public void set_link_accomodation(String str){
		Accomodation_txt=str ; 
	}
	public void set_link_clients(String str){
		Clients_txt=str ; 
	}
	
	public String get_link_accomodation(){
		return Accomodation_txt ; 
	}
	public String get_link_clients(){
		 return Clients_txt ; 
	}
	public Accomodation get_accomo(int i) {
		return accomo[i] ;
	}
	public Customers get_customer(int i) {
		return clients[i] ;
	}
	public int numberOfCustomers() {
		int i = 0 ; 
		while(clients[i]!= null) {
			i++; 
		}
		return i ; 
	}
	
	public void set_client(int i , String name , String id ,  long tar) {
		clients[i] = new Customers(name ,id , tar, false) ; 
	}
	
	public int number_available_pitchs() {
		int i = 0 ; 
		for(int j = 0 ; j<12 ; j++ ) {
			if(accomo[j].type == 'P'&& accomo[j].getifavailable()==true) {
				i++; 
			}
		}
		return i ;
	}
	public int number_available_Cabins() {
		int i = 0 ; 
		for(int j = 0 ; j<12 ; j++ ) {
			if(accomo[j].type == 'B'&& accomo[j].getifavailable()==true) {
				i++; 
			}
		}
		return i ;
	}
	
	public int customer_exists(String str) {
		int i = 0 ; 
		while(i <numberOfCustomers()) {
			if(str.equals(clients[i].getid())) {
	       return i ; 
	      }
			i++ ; 
			
		}
		return 2000 ; 
	}
	public int accomo_exists(String str) {
		int i = 0 ; 
		while(i<12) {
			if(str.equals(accomo[i].getid())){
				return i ; 
			}
			i++ ;
		}
		return 2000 ; 
	}
	public void info_all_accomo() {
		for(int i = 0 ; i<12 ;i++) {
			if( accomo[i].getifavailable()) {
				System.out.println(accomo[i].toString()) ;
			}
		}
	}
	
	
	//dependency here
	public String get_web(WebPlatform w) {
		return w.toString() ; 
	}
	public String get_comp(CleaningAndMaintenance c) {
		return c.toString() ;
	}
	
	public int total_cost_of_cleaning() {
		int total ; 
		int cabins  = 0; 
		int bbq = 0 ; 
		for (int i = 0  ; i < 12 ; i++) {
			if(accomo[i].getid().charAt(0) == 'B' && accomo[i].getifavailable()== true) {
				cabins++ ; 
				if(accomo[i].HasBarbacue()) {
					bbq++ ; 
				}
			}
		}
		total = bbq*2 + cabins*15 ; 
		return total ;
	}
	public double total_cost_web( Customers c) {
		int res_counter = 0 ;
		double result = 0 ; 
		for (int i = 0  ; i < 12 ; i++) {
			if(accomo[i].getid().charAt(0) == 'B' && accomo[i].getifavailable()== false && c.get_reser(res_counter).getdays() >=  7 && c.get_reser(res_counter).get_accomo().equals(accomo[i])) {
			  
			  result = result + c.get_reser(res_counter).getdays()*c.get_reser(res_counter).get_accomo().getpricepernight()*0.05 ; 
			   res_counter++ ;
			}
		}
		return result ; 
	}
	public boolean check_ID(String str) {
		int j = 0 ; 
		int c = 0 ; 
		for(int i = 0 ; i <9 ;i++) {
			 Boolean flag = Character.isDigit(str.charAt(i));
			if(flag) {
	         j++;
			}
			else {
				c++ ;
			}
		}
		if(j == 8 && c == 1) {
			return true ; 
		}
		else return false  ; 
	
	}
	  public static void readClientes (String cadena , Customers[] clients)throws IOException{
			int counter = 0 ;
		    File f=new File(cadena);
		    Scanner nombre_f = new Scanner (f);
		    while (nombre_f.hasNext()){
		      String no=nombre_f.next();
		      String dni=nombre_f.next();
		      long tar= nombre_f.nextLong();
		   
		      boolean joven=nombre_f.nextBoolean();
		  
		      if (joven){
		        int nc=nombre_f.nextInt();
		        clients[counter] = new VIP(no , dni , tar ,nc, joven ) ;
		      
		      }else {
		    	    clients[counter] = new Customers(no , dni , tar,joven ) ;
		      }
		       	
		      counter++ ; 
		    }
		    nombre_f.close();
		    
		  } 
	  
	  public void write(Customers c) throws IOException{
		  String g = c.getname() +" "+c.getid()+" "+c.getcreditcard()+" false" ;
		  FileWriter fw = new FileWriter(Clients_txt , true) ;
		  BufferedWriter bw = new BufferedWriter(fw) ; 
		  PrintWriter pw = new PrintWriter(fw) ; 
		  pw.print("\n"+g) ;
		  fw.close(); 
		  bw.close(); 
		  pw.close(); 
	  }
	public static void readACCOMODATION (String cadena , Accomodation[] accom)throws IOException{
			int counter_accom = 0 ; 
		    File f= new File(cadena);
		    Scanner nombre_f = new Scanner (f);
		    while (nombre_f.hasNext()){
		      String line =nombre_f.next();
		      char type =line.charAt(0);
		      String id=nombre_f.next();
		      int price= nombre_f.nextInt();
		      int numberOfpeople= nombre_f.nextInt();
		      int area= nombre_f.nextInt();
		      
		      
		      if(type =='c') {
		    	  int new_num = nombre_f.nextInt() ; 
		    	  boolean joven=nombre_f.nextBoolean();
		    	 accom[counter_accom ]= new Cabin(id, price,  numberOfpeople,  area , new_num , joven) ; 
		    	 counter_accom++ ; 

		      }else {
		    	   boolean joven=nombre_f.nextBoolean();
		    	   boolean joven2=nombre_f.nextBoolean();
		    	   accom[counter_accom ] = new Pitch(id ,price,numberOfpeople,area,joven,joven2) ; 
		    	   counter_accom++ ; 
		      }
		    }
		    nombre_f.close();
		  }  
	}
	
