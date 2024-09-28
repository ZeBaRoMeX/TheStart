package EntityList;
import Entity.BloodReceiver;
public class ReceiverList{
	private BloodReceiver receivers[];
	public ReceiverList(){
		receivers = new BloodReceiver[5];
	}
	public ReceiverList(short size){
		receivers = new BloodReceiver[size];
	}
	public void enter(BloodReceiver d){
		boolean flag = false;
		for(short i=0;i<receivers.length;i++){
			if(receivers[i]==null){
				receivers[i] = d;
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
	
	public BloodReceiver getById(String id){
		boolean flag = false;
		BloodReceiver d = null;
		for(short i=0;i<receivers.length;i++){
			if(receivers[i]!=null){
				if(receivers[i].getReceiverID().equals(id)){
					d = receivers[i];
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("BloodReceiver found.");
		}
		else{
			System.out.println("BloodReceiver not found.");
		}
		return d;
	}
	
	public void removeById(String id){
		boolean flag = false;
		for(short i=0;i<receivers.length;i++){
			if(receivers[i]!=null){
				if( receivers[i].getReceiverID().equals(id)){
					receivers[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("BloodReceiver Removed.");
		}
		else{
			System.out.println("No BloodReceiver found with this id.");
		}
	}
	
	public void showAll(){
		for(short i=0;i<receivers.length;i++){
			if(receivers[i]!=null){
				System.out.println("-------------");
				receivers[i].showInfo();
				System.out.println("-------------");
			}
		}
	}
	
	public String getAllReceiversAsString(){
		String allReceivers="";
		for(short i=0;i<receivers.length;i++){
			if(receivers[i]!=null){
				allReceivers += "-------------"+"\n"+
							receivers[i].getReceiverAsString()+"\n"+
							"-------------"+"\n";
			}
		}
		return allReceivers;	
}
    public BloodReceiver[] getAllReceivers(){
		return receivers;
	}
}