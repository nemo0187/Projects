package project;


public class WebPlatform {
	private double percentage; 
	private String name; 
	
	//constructor
	public WebPlatform(double num, String NAME) {
		percentage = num ; 
		name = NAME ; 
	}
	
	//getters and setters
	public String getname() {
		return name ; 
	}
	
	public void setname(String x) {
		name=x;
	}
	
	public double getpercentage() {
		return percentage; 
	}
	
	public void setpercentage(double x) {
		percentage=x;
	}
	
	//method toString to show all the information
	public String toString() {
		return "The name of the platform is " + name + " and the percentage is " + percentage;
	}
}
