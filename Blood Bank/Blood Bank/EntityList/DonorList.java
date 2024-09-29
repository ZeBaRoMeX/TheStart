package EntityList;
import Entity.BloodDonor;
public class DonorList{
	private BloodDonor donors[];
	public DonorList(){
		donors = new BloodDonor[5];
	}
	public DonorList(short size){
		donors = new BloodDonor[size];
	}
	public void enter(BloodDonor d){
		boolean flag = false;
		for(short i=0;i<donors.length;i++){
			if(donors[i]==null){
				donors[i] = d;
				flag = true;
				break;
			}
		}
		
		if(flag){
			System.out.println("Entry successful.");
		}
		else{
			System.out.println("Entry failed.");
		}
	}
	
	public BloodDonor getById(String id){
		boolean flag = false;
		BloodDonor d = null;
		for(short i=0;i<donors.length;i++){
			if(donors[i]!=null){
				if(donors[i].getDonorID().equals(id)){
					d = donors[i];
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("BloodDonor found.");
		}
		else{
			System.out.println("BloodDonor not found.");
		}
		return d;
	}
	
	public void removeById(String id){
		boolean flag = false;
		for(short i=0;i<donors.length;i++){
			if(donors[i]!=null){
				if( donors[i].getDonorID().equals(id)){
					donors[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("BloodDonor Removed.");
		}
		else{
			System.out.println("No BloodDonor found with this id.");
		}
	}
	
	public void showAll(){
		for(short i=0;i<donors.length;i++){
			if(donors[i]!=null){
				System.out.println("-------------");
				donors[i].showInfo();
				System.out.println("-------------");
			}
		}
	}
	
	public String getAllDonorsAsString(){
		String allDonors="";
		for(short i=0;i<donors.length;i++){
			if(donors[i]!=null){
				allDonors += "-------------"+"\n"+
							donors[i].getDonorAsString()+"\n"+
							"-------------"+"\n";
			}
		}
		return allDonors;
	}
	
	public BloodDonor[] getAllDonors(){
		return donors;
	}
}