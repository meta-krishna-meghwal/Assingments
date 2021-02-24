package zooManagement;

import java.util.ArrayList;

public class Zone extends Zoo {
	String animalType;
	
	static int noOfCages = 10;
	static ArrayList<Cage> cageList = new ArrayList<Cage>();
	
	public Zone(String type){
		this.animalType = type;
	}
	
	public boolean addCage(){
		boolean flag = true;
		if(cageList.size() < noOfCages){
			Cage c = new Cage();
			cageList.add(c);
			System.out.println("Cage created");
		}else{
			flag = false;
			System.out.println("Cage is full!!!");
		}
		return flag;
	}
	
	
	public static void main(String [] args){
		for(int i=0; i < 20; i++){
			String type = "mammal";
			addZone(type);
		}
	}
}
