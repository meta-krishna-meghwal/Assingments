package zooManagement;

import java.util.ArrayList;

public class Cage extends Animal{
	
	public int cageId;
	public int noOfAnimals = 10;
	static ArrayList<Animal> animalList = new ArrayList<Animal>();
	
	public Cage(){
		cageId  = (int)Math.random() * 1000;
	}
	
	public boolean addAnimal(){
		
		if(animalList.size() < noOfAnimals){
			Animal a = new Animal();
			animalList.add(a);
			return true;
		}
		
		return false;
		
	}

}
