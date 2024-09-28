package Entity;
public class BloodReceiver{
	private String receiverID;
	private String receiverName;
	private short receiverAge;
	private String receiverGender;
	private String requiredBloodGroup;
	private String requiredBloodProduct;
	private float requiredAmount;
	private String location;
	
	private static short receiverCounter=0;
	public BloodReceiver(){}
	public BloodReceiver(String receiverID,String receiverName,short receiverAge,String receiverGender,String requiredBloodGroup, String requiredBloodProduct, float requiredAmount,String location){
		this.receiverName=receiverName;
		this.receiverAge=receiverAge;
		this.receiverID=receiverID;
		this.receiverGender=receiverGender;
		this.requiredBloodGroup=requiredBloodGroup;
		this.requiredBloodProduct=requiredBloodProduct;
		this.requiredAmount=requiredAmount;
		this.location=location;
		receiverCounter++;
	} 
	public void setReceiverID(String receiverID){
		this.receiverID=receiverID;
	}
	public String getReceiverID(){
		return receiverID;
	}
	public void setReceiverName(String receiverName){
		this.receiverName=receiverName;
	}
	public String getReceiverName(){
		return receiverName;
	}
		
	public void setReceiverGender(String receiverGender){
		this.receiverGender=receiverGender;
	}
	public String getReceiverGender(){
		return receiverGender;
	}
	public void setReceiverAge(short receiverAge){
		this.receiverAge=receiverAge;
	}
	public short getReceiverAge(){
		return receiverAge;
	}
	public void setRequiredBloodGroup(String requiredBloodGroup){
		this.requiredBloodGroup=requiredBloodGroup;
	}
	public String getRequiredBloodGroup(){
		return requiredBloodGroup;
	}
	public void setRequiredBloodProduct(String requiredBloodProduct){
		this.requiredBloodProduct=requiredBloodProduct;
	}
	public String getRequiredBloodProduct(){
		return requiredBloodProduct;
	}
	public void setRequiredAmount(float requiredAmount){
		this.requiredAmount=requiredAmount;
	}
	public float getRequiredAmount(){
		return requiredAmount;
	}
	public void setLocation(String location){
		this.location=location;
	}
	public String getLocation(){
		return location;
	}
	
	public void showInfo(){
		System.out.println("Receipient ID: "+receiverID);
		System.out.println("Recipient Name: "+receiverName);
		System.out.println("Recipient Age: "+receiverAge);
		System.out.println("Recipient Gender: "+receiverGender);
		System.out.println("Required Blood Group: "+requiredBloodGroup);
		System.out.println("Required Blood Product: "+requiredBloodProduct);
		System.out.println("Amount Required: "+requiredAmount+" cc");
		System.out.println("Admitted in: "+location);
	}
	
	public String getReceiverAsString(){
		
		String s =  "Receipient ID: "+receiverID+"\n"+
                    "Recipient Name: "+receiverName+"\n"+
                    "Recipient Age: "+receiverAge+"\n"+
                    "Recipient Gender: "+receiverGender+"\n"+
                    "Required Blood Group: "+requiredBloodGroup+"\n"+
                    "Required Blood Product: "+requiredBloodProduct+"\n"+
                    "Amount Required: "+requiredAmount+" cc"+"\n"+
                    "Admitted in: "+location;
		return s;
	}
	
	public static void totalNumberOfReceivers(){
		System.out.println("Number of receivers:"+receiverCounter);
	}
}