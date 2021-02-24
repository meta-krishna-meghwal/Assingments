package zooManagement;

import java.util.ArrayList;

public abstract class Zoo {
	
	static String zooName = "The Royal Zoo";
	static int noOfZone = 15;
	static ArrayList<Zone> zoneList = new ArrayList<Zone>();
	
	
	public static boolean addZone(String type){
		
		if(zoneList.size() < noOfZone){
			Zone z = new Zone(type);
			zoneList.add(z);
			System.out.println("Zone created");
			return true;
			
		}else{
			
			System.out.println("Zoo is full!!!");
		}
		return false;
	}
		
}
