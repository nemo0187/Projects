package project;

import java.io.IOException;
import java.util.Scanner;


public class main {
	public static void main(String[] args) throws IOException{
		
        Campsite campsite_obj = new Campsite("C:\\Users\\rehim\\eclipse-workspace\\project\\Accomodation.txt"  , "C:\\\\Users\\\\rehim\\\\eclipse-workspace\\\\project\\\\Clientes.txt") ; 

        welcome_screen(0 , campsite_obj);   
     
	}
	
	public static void welcome_screen(int i , Campsite campsite_obj) {
		if(i == 0) {
			System.out.println("hello and welcome to our Campsite :  "+"\n" +"in order to start please click 1 if you are an existing customer , if you are a new customer click 2 : ") ; 
		}
		else {
			System.out.println(" Please choose one the two options !!!") ;  
		}
		try {
			Scanner sc= new Scanner(System.in); 
		 int a= sc.nextInt(); 
		 if(a == 1) {
			 System.out.println("Please enter your ID number in order to Login :");
			 String no=sc.next();
			 int track = campsite_obj.customer_exists(no) ; 
			 if(track == 2000) {
				 System.out.println("please Enter your ID correctly or register!!! "+no) ;
				 welcome_screen(1 , campsite_obj)  ; 
			 }
			 else {
				 Customers customer = campsite_obj.get_customer(track) ;
				 System.out.println("welcome "+ customer.getname()+"!!!") ; 
				 working_screen(customer,campsite_obj); 
			 }
			 
		 }
		 else if(a == 2) {
			  try{System.out.println("Name: "); 
		          String no=sc.next();
		          System.out.println("please Enter your ID correctly: ");
		          String dni=sc.next();
		          if(campsite_obj.check_ID(dni) == false) {
		           System.out.println("please Enter your ID correctly !!");
		    	   welcome_screen(0 , campsite_obj) ;
		          }
		          System.out.println("please Enter your credit card number : ");
		          long tar= sc.nextLong(); 
		          campsite_obj.set_client(campsite_obj.numberOfCustomers(), no, dni, tar); //.clients[campsite_obj.numberOfCustomers() Customers(no , dni , tar , false); //adds new customer to the array :) 
		          campsite_obj.write(campsite_obj.get_customer(campsite_obj.numberOfCustomers()-1));
			  }catch(Exception e) {
				   System.out.println("ERROR TRY AGAIN !!");
				  welcome_screen(0 , campsite_obj) ;
			  }
			  System.out.println("Customer was added !!");
			  
			  welcome_screen(0 ,campsite_obj) ; 
		 }
		 else {
				welcome_screen(1 ,campsite_obj) ; 
		 }
		}catch(Exception e) {
			System.out.println("Enter a number please !!!");
			welcome_screen(1 , campsite_obj)  ; 
		}
	}
	public static void Return_button(Customers client, Campsite campsite_obj) {
		System.out.println("if you want to go back to the options press 5 , if you want to go back to the main menu press any other number :"); 
		try {
		try (Scanner sc = new Scanner(System.in)) {
			int d= sc.nextInt(); 
			if(d==5) {
				working_screen(client, campsite_obj) ;
			}
			else {
				welcome_screen(0, campsite_obj) ;
			}
		}
		}catch(Exception e) {
			System.out.println("Please enter a number!!!!! ") ; 
			Return_button(client,  campsite_obj); 
		}
	}
	public static void working_screen(Customers client, Campsite campsite_obj) {
		try {
			
		System.out.println("please enter the number of the action that you want:") ;
		System.out.println("1. See the information about all the available accomodations ") ;
		System.out.println("2. See the the cost of cleaning ") ;
		System.out.println("3. reserve accommodation ") ;
		System.out.println("4. cost of the reservations for the wanted number of days before and after discount ") ;
		System.out.println("5. See the information about all your reservations ") ;
		System.out.println("6. how much will the web operator earn ?  ") ;
		if(client.vip == true) {
		System.out.println("7. information regarding all the accommodation items with barbecues  ") ;
		}
		Scanner sc= new Scanner(System.in);
		int a= sc.nextInt(); 
		if(a == 1 ) {
			campsite_obj.info_all_accomo(); 
	        Return_button(client,campsite_obj) ; 
		}
		if(a == 2 ) {
			CleaningAndMaintenance company = new CleaningAndMaintenance("Limpieza y Mantenimiento S.L", 15,2) ; 
			System.out.println(campsite_obj.get_comp(company)) ; 
			System.out.println("so the total Cost will be for cabins :"); 
			System.out.println(campsite_obj.total_cost_of_cleaning()) ;
			Return_button(client,campsite_obj) ; 
			
		}
		
		//third options full functionality 
		if( a== 3 ) {
			System.out.println("please enter the ID of the accomodation that you wish to reserve :");
			try {
						String jwab = sc.next();
						int result = campsite_obj.accomo_exists(jwab) ;
						System.out.println(jwab);
						if(result== 2000) {
							System.out.println("error here , This accamodation doesnt exist!!");
							Return_button(client,campsite_obj) ; 
						}
						else {
							if(campsite_obj.get_accomo(result).getifavailable()) {
								System.out.println("ok this accomodation is available , can you enter the number days that you want to reserv it ?");
								try{
									int num_days= sc.nextInt();
									if(num_days < 0) {
										System.out.println("please enter a positive number");
										Return_button(client,campsite_obj) ; 
									}
									client.addReserv(num_days, campsite_obj.get_accomo(result), client);
									campsite_obj.get_accomo(result).setavailable(false);
								}
								catch(Exception e) {
									System.out.println("please enter a number");
									Return_button(client,campsite_obj) ; 
								}
							}else {
								System.out.println("sorry its not available at the moment" ); 
								Return_button(client,campsite_obj) ; 
							}
						}
			}catch(Exception e){
				System.out.println("please enter the ID of the Room correctly") ;
				Return_button(client,campsite_obj) ;
			}
			Return_button(client,campsite_obj) ; 
		}
		if(a == 4) {
					if(client.get_nReservations() == 0) {
						System.out.println("Sorry You have no Reservations!!") ;
						Return_button(client,campsite_obj) ;
					}
					else {
						int number_of_reservations = client.get_nReservations() ; 
						for(int i = 0 ; i <number_of_reservations ;i++) {
							long num = 0 ;
							int dis = client.calculateDisc() ; 
						    double result  ;
							int number_days = client.get_reser(i).getdays() ; 
							int price = client.get_reser(i).accomo.getpricepernight() ;
							num = price*number_days ; 
	                        if(dis == 10) {
	                        	result = num * 0.9 ;
	                        }
	                        else if(dis == 5) {
	                        	result = num * 0.95 ;
	                        }else {
	                        	result = num ;
	                        }
							System.out.println("the total cost of your accomodation with ID : "+client.get_reser(i).accomo.getid()+" is "+num+" €") ; 
							System.out.println("and the price after discount for ID : "+client.get_reser(i).accomo.getid()+" is "+result+" €") ; 
						}
						Return_button(client,campsite_obj) ;
					}
		}
		if(a == 5) {
			if(client.get_nReservations() == 0) {
				System.out.println("Sorry You have no Reservations!!") ;
				Return_button(client,campsite_obj) ;
			}
			else {
				int number_of_reservations = client.get_nReservations() ; 
				for(int i = 0 ; i <number_of_reservations ;i++) {
					
					System.out.println(client.get_reser(i).accomo.toString()) ; 
					
				}
				Return_button(client,campsite_obj) ;
			}
		}
		if( a == 6 ) {
			   WebPlatform w = new WebPlatform (0.05 ,"Online networks" ) ;
			System.out.println(campsite_obj.get_web(w)); 
		   System.out.println(" the web opirator will charge %5 of the total cost of a cabin that has been reserved for a week or more ");
		   System.out.println(campsite_obj.total_cost_web(client)) ; 
		   Return_button(client,campsite_obj) ;
		}
		if( a == 7 ) {
			for(int i = 0 ; i <client.get_nReservations()  ; i++ ) {
				if(client.get_reser(i).accomHasBarbacue()) {
					 System.out.println(client.get_reser(i).toString()); 
				}
			}
			Return_button(client,campsite_obj) ;
			}
		else {
			System.out.println("Please choose one of the options !!!") ;
			Return_button(client,campsite_obj) ;
		}
		}catch(Exception e) {
			System.out.println("error !!") ;
			Return_button(client,campsite_obj) ;
		}
	}
	
	
}
 