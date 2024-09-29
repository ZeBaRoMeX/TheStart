package Entity;
public class BloodInventory{
	private String storageID;
	private String bloodGroup;
	private float wholeBloodAmount;
	private float bloodPlasmaAmount;
	private float rbcAmount;
	private float plateletAmount;
	private float cryoPPTAmount;
	private short expiryDay;
	private short expiryMonth;
	private short expiryYear;
	
	private static short itemCounter=0;
	
	public BloodInventory(){}
	public BloodInventory(String storageID, String bloodGroup, float wholeBloodAmount, float bloodPlasmaAmount, float rbcAmount, float plateletAmount, float cryoPPTAmount, short expiryDay,short expiryMonth,short expiryYear){
		this.storageID=storageID;
		this.bloodGroup=bloodGroup;
		this.wholeBloodAmount=wholeBloodAmount;
		this.bloodPlasmaAmount=bloodPlasmaAmount;
		this.rbcAmount=rbcAmount;
		this.plateletAmount=plateletAmount;
		this.cryoPPTAmount=cryoPPTAmount;
		this.expiryDay=expiryDay;
		this.expiryMonth=expiryMonth;
		this.expiryYear=expiryYear;
		itemCounter++;
	}
	
	public void setStorageID(String storageID){this.storageID=storageID;}
	public String getStorageID(){return storageID;}
	
	public void setBloodGroup(String bloodGroup){this.bloodGroup=bloodGroup;}
	public String getBloodGroup(){return bloodGroup;}
	
	public void setWholeBloodAmount(float wholeBloodAmount){this.wholeBloodAmount=wholeBloodAmount;}
	public float getWholeBloodAmount(){return wholeBloodAmount;}
	
	public void setBloodPlasmaAmount(float bloodPlasmaAmount){this.bloodPlasmaAmount=bloodPlasmaAmount;}
	public float getBloodPlasmaAmount(){return bloodPlasmaAmount;}
	
	public void setRBCAmount(float rbcAmount){this.rbcAmount=rbcAmount;}
	public float getRBCAmount(){return rbcAmount;}
	
	public void setPlateletAmount(float plateletAmount){this.plateletAmount=plateletAmount;}
	public float getPlateletAmount(){return plateletAmount;}
	
	public void setCryoPPTAmount(float cryoPPTAmount){this.cryoPPTAmount=cryoPPTAmount;}
	public float getCryoPPTAmount(){return cryoPPTAmount;}
	
	public void setExpiryDay(short expiryDay){this.expiryDay=expiryDay;}
	public short getExpiryDay(){return expiryDay;}
	
	public void setExpiryMonth(short expiryMonth){this.expiryMonth=expiryMonth;}
	public short getExpiryMonth(){return expiryMonth;}
	
	public void setExpiryYear(short expiryYear){this.expiryYear=expiryYear;}
	public short getExpiryYear(){return expiryYear;}
	
	public void showInfo(){
		System.out.println("Storage ID:"+storageID);
		System.out.println("Blood Group:"+bloodGroup);
		System.out.println("Whole Blood in storage:"+wholeBloodAmount);
		System.out.println("Blood plasma in storage:"+bloodPlasmaAmount);
		System.out.println("Red Blood Cells in storage:"+rbcAmount);
		System.out.println("Platelets in storage:"+plateletAmount);
		System.out.println("Cryoprecipitate in storage:"+cryoPPTAmount);
		System.out.println("Expiration date:"+expiryDay+"/"+expiryMonth+"/"+expiryYear);
	}
	
	public String getItemAsString(){
		
		String s =  "Storage ID: "+storageID+"\n"+
					"Blood Group: "+bloodGroup+"\n"+
					"Whole Blood in storage: "+wholeBloodAmount+" cc"+"\n"+
					"Blood plasma in storage: "+bloodPlasmaAmount+" cc"+"\n"+
					"Red Blood Cells in storage: "+rbcAmount+" cc"+"\n"+
					"Platelets in storage: "+plateletAmount+" cc"+"\n"+
					"Cryoprecipitate in storage: "+cryoPPTAmount+" cc"+"\n"+
					"Expiration date: "+expiryDay+"/"+expiryMonth+"/"+expiryYear;
		return s;
	}
	
	public static void totalNumberOfUniqueID(){
		System.out.println("Total number of registered items: " + itemCounter);
	}
}