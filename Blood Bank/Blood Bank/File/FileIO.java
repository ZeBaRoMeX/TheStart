package File;
import java.io.*;
import java.util.Scanner;
import Entity.*;
import EntityList.*;

public class FileIO{
	public static boolean checkUser(String userName, String userPass){
			boolean flag = false;
			try{
				Scanner fsc = new Scanner(new File("./File/users.txt"));
				while(fsc.hasNextLine()){
					String line = fsc.nextLine();
					String data[] = line.split(";");
					if(userName.equals(data[0]) && userPass.equals(data[1])){
						flag = true;
						break;
					}
				}
				fsc.close();
			}
			catch(Exception ex){
				System.out.println("Cannot Read File");
			}
			return flag;
	}
	public static boolean registerNewUser(String userName, String userPass){
		boolean flag = false;
		
		if(userExists(userName)){
			return flag;
		}
		
		try{
			FileWriter fw = new FileWriter(new File("./File/users.txt"),true);
			String line = userName+";"+userPass+"\n";
			fw.write(line);
			fw.flush();
			fw.close();
			flag = true;
		}
		catch(Exception ex){
			System.out.println("File Not Found");
		}
		return flag;
	}
	
	
	public static boolean userExists(String userName){
		boolean flag = false;
		try{
			Scanner fsc = new Scanner(new File("./File/users.txt"));
			while(fsc.hasNextLine()){
				    String line = fsc.nextLine();
					String data[] = line.split(";");
					if(userName.equals(data[0])){
						flag = true;
						break;
					}
			}
		}
		catch(Exception ex){
			System.out.println("Cannot Read File");
		}
		return flag;	
	}
	
	public static void loadItemsFromFile(InventoryList inventoryList){
			try{
				Scanner fsc = new Scanner(new File("./File/inventory.txt"));
				while(fsc.hasNextLine()){
					String line = fsc.nextLine();
					String data[] = line.split(";");
					BloodInventory b = new BloodInventory(data[0],data[1],Float.parseFloat(data[2]),
					                                      Float.parseFloat(data[3]),Float.parseFloat(data[4]),
														  Float.parseFloat(data[5]),Float.parseFloat(data[6]),
														  Short.parseShort(data[7]),Short.parseShort(data[8]),Short.parseShort(data[9]));
					inventoryList.enter(b);
				}
				fsc.close();
			}
			catch(Exception ex){
				System.out.println("Cannot Read File");			
			}
	}
	
	public static void writeItemInFile(BloodInventory b){
		try{
			FileWriter fw = new FileWriter(new File("./File/inventory.txt"),true);
			String line = b.getStorageID()+";"+b.getBloodGroup()+";"+
						  b.getWholeBloodAmount()+";"+b.getBloodPlasmaAmount()+";"+
						  b.getRBCAmount()+";"+b.getPlateletAmount()+";"+
						  b.getCryoPPTAmount()+";"+b.getExpiryDay()+";"+b.getExpiryMonth()+";"+b.getExpiryYear()+"\n";
			fw.write(line);
			fw.flush();
			fw.close();
		}
		catch(Exception ex){
			System.out.println("File Not Found");
		
		}
	}
	
	public static void updateItemInFile(InventoryList inventoryList){
		try{
			FileWriter fw = new FileWriter(new File("./File/inventory.txt"),false);
			for(BloodInventory b : inventoryList.getAllItems()){
				if(b!=null){
			                String line = b.getStorageID()+";"+b.getBloodGroup()+";"+
			                			  b.getWholeBloodAmount()+";"+b.getBloodPlasmaAmount()+";"+
			                			  b.getRBCAmount()+";"+b.getPlateletAmount()+";"+
			                			  b.getCryoPPTAmount()+";"+b.getExpiryDay()+";"+b.getExpiryMonth()+";"+b.getExpiryYear()+"\n";
			                fw.write(line);
				}
			}
			fw.flush();
			fw.close();
		}
		catch(Exception ex){
			System.out.println("File Not Found");		
		}
	}
	
	public static void loadDonorsFromFile(DonorList donorList){
			try{
				Scanner fsc = new Scanner(new File("./File/donors.txt"));
				while(fsc.hasNextLine()){
					String line = fsc.nextLine();
					String data[] = line.split(";");
					BloodDonor b = new BloodDonor(data[0],data[1],
												  Short.parseShort(data[2]),data[3],data[4],
												  Short.parseShort(data[5]),Short.parseShort(data[6]),Short.parseShort(data[7]),
												  Float.parseFloat(data[8]));
					donorList.enter(b);
				}
				fsc.close();
			}
			catch(Exception ex){
				System.out.println("Cannot Read File");
			
			}
	}
	
	public static void writeDonorInFile(BloodDonor b){
		try{
			FileWriter fw = new FileWriter(new File("./File/donors.txt"),true);
			String line = b.getDonorID()+";"+b.getDonorName()+";"+
						  b.getDonorAge()+";"+b.getDonorGender()+";"+
						  b.getDonorBloodGroup()+";"+b.getDonationDay()+";"+b.getDonationMonth()+";"+b.getDonationYear()+";"+
						  b.getAmountDonated()+"\n";
			fw.write(line);
			fw.flush();
			fw.close();
		}
		catch(Exception ex){
			System.out.println("File Not Found");
		
		}
	}
	
	public static void updateDonorInFile(DonorList donorList){
		try{
			FileWriter fw = new FileWriter(new File("./File/donors.txt"),false);
			for(BloodDonor b : donorList.getAllDonors()){
				if(b!=null){
			                String line = b.getDonorID()+";"+b.getDonorName()+";"+
						                  b.getDonorAge()+";"+b.getDonorGender()+";"+
						                  b.getDonorBloodGroup()+";"+b.getDonationDay()+";"+b.getDonationMonth()+";"+b.getDonationYear()+";"+
						                  b.getAmountDonated()+"\n";
			                fw.write(line);
				}
			}
			fw.flush();
			fw.close();
		}
		catch(Exception ex){
			System.out.println("File Not Found");		
		}
	}
		
	public static void loadReceiversFromFile(ReceiverList receiverList){
			try{
				Scanner fsc = new Scanner(new File("./File/receivers.txt"));
				while(fsc.hasNextLine()){
					String line = fsc.nextLine();
					String data[] = line.split(";");
					BloodReceiver b = new BloodReceiver(data[0],data[1],
														Short.parseShort(data[2]),data[3],data[4],
														data[5],Float.parseFloat(data[6]),data[7]);
					receiverList.enter(b);
				}
				fsc.close();
			}
			catch(Exception ex){
				System.out.println("Cannot Read File");
			
			}
	}
	
	public static void writeReceiverInFile(BloodReceiver b){
		try{
			FileWriter fw = new FileWriter(new File("./File/receivers.txt"),true);
			String line = b.getReceiverID()+";"+b.getReceiverName()+";"+
						  b.getReceiverGender()+";"+b.getReceiverAge()+";"+
						  b.getRequiredBloodGroup()+";"+b.getRequiredBloodProduct()+";"+
						  b.getRequiredAmount()+";"+b.getLocation()+"\n";
			fw.write(line);
			fw.flush();
			fw.close();
		}
		catch(Exception ex){
			System.out.println("File Not Found");
		
		}
	}
	
	public static void updateReceiverInFile(ReceiverList receiverList){
		try{
			FileWriter fw = new FileWriter(new File("./File/receivers.txt"),false);
			for(BloodReceiver b : receiverList.getAllReceivers()){
				if(b!=null){
			                String line = b.getReceiverID()+";"+b.getReceiverName()+";"+
						                  b.getReceiverGender()+";"+b.getReceiverAge()+";"+
						                  b.getRequiredBloodGroup()+";"+b.getRequiredBloodProduct()+";"+
						                  b.getRequiredAmount()+";"+b.getLocation()+"\n";
			                fw.write(line);
				}
			}
			fw.flush();
			fw.close();
		}
		catch(Exception ex){
			System.out.println("File Not Found");		
		}
	}	
}