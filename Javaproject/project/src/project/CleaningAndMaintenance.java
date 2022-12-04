package project;


public class CleaningAndMaintenance {
	private String name;
	private int chargesForCabins;
	private int chargesForBarbacue;
	
	//constructor
	public CleaningAndMaintenance(String NAME, int chargesForCABINS, int chargesForBARBACUE) {
		name = NAME;
		chargesForCabins = chargesForCABINS;
		chargesForBarbacue = chargesForBARBACUE;
	}
	
	//getters and setters
	public String getname() {
		return name;
	}
	
	public void setname(String x) {
		name=x;
	}
	
	public int getchargesforcabins() {
		return chargesForCabins;
	}
	
	public void setchargesforcabins(int x) {
		chargesForCabins=x;
	}
	
	public int getchargesforbarbacue() {
		return chargesForBarbacue;
	}
	
	public void setchargesforbarbacue(int x) {
		chargesForBarbacue=x;
	}
	
	//method toString to show all the information
	public String toString() {
		return "The name of the cleaning and maintenance company is " + name + " and charges for cabins are: " + chargesForCabins + " and for barbacues: " + chargesForBarbacue;
	}
}
