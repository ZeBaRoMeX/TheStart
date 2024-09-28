package Entity;
public class BloodDonor{
	private String donorID;
	private String donorName;
	private short donorAge;
	private String donorGender;
	private short donationDay;
	private short donationMonth;
	private short donationYear;
	private String donorBloodGroup;
	private float amountDonated;
	
	private static short donorCounter=0;
	
	public BloodDonor(){}
	public BloodDonor(String donorID,String donorName,short donorAge,String donorGender, String donorBloodGroup, short donationDay, short donationMonth, short donationYear,float amountDonated){
		this.donorID=donorID;
		this.donorName=donorName;
		this.donorAge=donorAge;
		this.donorGender=donorGender;
		this.donationDay=donationDay;
		this.donationMonth=donationMonth;
		this.donationYear=donationYear;
		this.donorBloodGroup=donorBloodGroup;
		this.amountDonated=amountDonated;
		donorCounter++;
	}
	public void setDonorID(String donorID){
	this.donorID=donorID;
	}
	public String getDonorID(){
		return donorID;
	}
	public void setDonorName(String donorName){
		this.donorName=donorName;
	}
	public String getDonorName(){
		return donorName;
	}
	public void setDonorAge(short donorAge){
		this.donorAge=donorAge;
	}
	public short getDonorAge(){
		return donorAge;
	}
	public void setDonorGender(String donorGender){
		this.donorGender=donorGender;
	}
	public String getDonorGender(){
		return donorGender;
	}
	public void setDonorBloodGroup(String donorBloodGroup){
		this.donorBloodGroup=donorBloodGroup;
	}
	public String getDonorBloodGroup(){
		return donorBloodGroup;
	}
	public void setDonationDay(short donationDay){
		this.donationDay=donationDay;
	}
	public short getDonationDay(){
		return donationDay;
	}
	public void setDonationMonth(short donationMonth){
		this.donationMonth=donationMonth;
	}
	public short getDonationMonth(){
		return donationMonth;
	}
	public void setDonationYear(short donationYear){
		this.donationYear=donationYear;
	}
	public short getDonationYear(){
		return donationYear;
	}
	public void setAmountDonated(float amountDonated){
		this.amountDonated=amountDonated;
	}
	public float getAmountDonated(){
		return amountDonated;
	}
		
	public void showInfo(){
		System.out.println("Donation ID:"+donorID);
		System.out.println("Name of donor:"+donorName);
		System.out.println("Age of donor:"+donorAge);
		System.out.println("Gender of donor:"+donorGender);
		System.out.println("Blood Group of donor:"+donorBloodGroup);
		System.out.println("Last donated on:"+donationDay+"/"+donationMonth+"/"+donationYear);
		System.out.println("Quantity donated:"+amountDonated);
	}
	
	public String getDonorAsString(){
		String s =  "Donation ID: "+donorID+"\n"+
					"Name of donor: "+donorName+"\n"+
					"Age of donor: "+donorAge+"\n"+
					"Gender of donor: "+donorGender+"\n"+
					"Blood Group of donor: "+donorBloodGroup+"\n"+
					"Last donated on: "+donationDay+"/"+donationMonth+"/"+donationYear+"\n"+
					"Quantity donated: "+amountDonated+" cc";
		return s;
	}
	
	public static void totalNumberOfDonors(){
		System.out.println("Number of donors:"+donorCounter);
	}
}