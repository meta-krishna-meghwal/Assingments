package assingment3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class intSet {
	private final int [] numbers = new int[1000];
	private final int size;
	
	private static Integer[] toConvertInteger(int[] ids) {

		  Integer[] newArray = new Integer[ids.length];
		     for (int i = 0; i < ids.length; i++) {
		       newArray[i] = Integer.valueOf(ids[i]);
		     }
		   return newArray;
		}
	private static int[] toint(Integer[] WrapperArray) {

		   int[] newArray = new int[WrapperArray.length];
		      for (int i = 0; i < WrapperArray.length; i++) {
		         newArray[i] = WrapperArray[i].intValue();
		      }
		   return newArray;
		}
	public intSet(int[] values){
		
		for(int number : values){
			this.numbers[number - 1] = 1;
		}
		
		this.size = values.length;
	}
	
	public boolean isMember(int x){
		boolean answer = false;
		
		if(x <= 1000 && x >= 1 && this.numbers[x-1] == 1){
			answer = true;			
		}
		
		return answer;
	}
	
	public int size(){
		return this.size;
	}
	
	public int[] getNumbers(){
		
		int[] answer = new int [this.size];
		int j = 0;
		for(int i=0; i < 1000; i++){
			
			if(this.numbers[i]==1){
				answer[j] = i + 1;
				j++;
			}
		}
		
		return answer;		
	}
	
	public boolean isSubSet(intSet s){
		boolean answer = true;
		int [] values = s.getNumbers();
		for(int i:values){
			if(this.numbers[i-1] != 1){
				answer = false;
				break;
			}
		}
		return answer;
	}
	
	public intSet getComplement(){
		int [] values = new int[1000 - this.size];
		int j = 0;
		for(int i=0; i < 1000; i++){
			if(this.numbers[i] != 1){
				values[j] = i + 1;
				j++;
			}
		}
		
		intSet s = new intSet(values);
		return s;
	}
	
	public intSet union(intSet s1, intSet s2){
		
		
		Integer [] numbers1 = toConvertInteger(s1.getNumbers());
		Integer [] numbers2 = toConvertInteger(s2.getNumbers());
		
		Set<Integer> unionOfArrays = new HashSet<>();
		unionOfArrays.addAll(Arrays.asList(numbers1));
		unionOfArrays.addAll(Arrays.asList(numbers2));
		Integer[] unionArray = {};
        unionArray = unionOfArrays.toArray(unionArray);
        int[] numbers = toint(unionArray);
        
        intSet s = new intSet(numbers);
        
        return s;
		
	}
	
	public static void main(String[] args){
		
		int [] numbers = {1,12,17,13,61,21,32,23,45,67,123,5,42,90,89};
		
		intSet s = new intSet(numbers);
		int [] n = {1,12,1000};
		intSet s2 = new intSet(n);

		System.out.println(s.isSubSet(s2));
	}
}
