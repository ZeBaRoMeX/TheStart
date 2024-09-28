package EntityList;
import Entity.BloodInventory;
public class InventoryList{
	private BloodInventory inv[];
	public InventoryList(){
		inv = new BloodInventory[1000];
	}
	public InventoryList(int size){
		inv = new BloodInventory[size];
	}
	public void enter(BloodInventory b){
		boolean flag = false;
		for(int i=0;i<inv.length;i++){
			if(inv[i]==null){
				inv[i] = b;
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
	
	public BloodInventory getById(String id){
		boolean flag = false;
		BloodInventory b = null;
		for(int i=0;i<inv.length;i++){
			if(inv[i]!=null){
				if(inv[i].getStorageID().equals(id)){
					b = inv[i];
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Item found.");
		}
		else{
			System.out.println("Item not found.");
		}
		return b;
	}
	
	public void removeById(String id){
		boolean flag = false;
		for(int i=0;i<inv.length;i++){
			if(inv[i]!=null){
				if( inv[i].getStorageID().equals(id)){
					inv[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Item Removed.");
		}
		else{
			System.out.println("No item found with this id.");
		}
	}
	
	public void showAll(){
		for(int i=0;i<inv.length;i++){
			if(inv[i]!=null){
				System.out.println("-------------");
				inv[i].showInfo();
				System.out.println("-------------");
			}
		}
	}

    public String getAllItemsAsString(){
		String allItems="";
		for(int i=0;i<inv.length;i++){
			if(inv[i]!=null){
				allItems += "-------------"+"\n"+
							inv[i].getItemAsString()+"\n"+
							"-------------"+"\n";
			}
		}
		return allItems;
	} 	
	
	public BloodInventory[] getAllItems(){
		return inv;
	}
}