package polynomial;

import java.util.Arrays;
import java.util.HashMap;

public final class Poly {
	
	private final Integer [] coefficients;
	private final Integer [] powers;
	private final int length;  
	private final int degree;  
	
	public Poly(HashMap<Integer,Integer> hash){
		
		Integer[] keys = new Integer[hash.keySet().size()];
		int k = 0;
		for(Integer i : hash.keySet())
		{
			keys[k++] = i;
		}
		
		Arrays.sort(keys);
		this.degree = keys.length - 1;
		
		Integer[] tempCoeffiicients = new Integer[keys.length];
		Integer[] tempPowers = new Integer[keys.length];
		
		int index = 0;
		for(int i=0; i < keys.length; i++){
			if(hash.get(keys[i]) != 0){
				tempCoeffiicients[index] = hash.get(keys[i]);
				tempPowers[index] = keys[i];
				index++;
			}
		}
		
		this.length = index;
		this.coefficients = new Integer[this.length];
		this.powers = new Integer[this.length];
		System.arraycopy( tempCoeffiicients, 0, this.coefficients, 0, this.length );
		System.arraycopy( tempPowers, 0, this.powers, 0, this.length );
	}
	
	public double evaluate(float x){
		double result = 0;
		for(int i = 0; i < this.length; i++){
			result += (this.coefficients[i] * Math.pow(x,this.powers[i]));
					
		}
		return result;
	}
	public Integer[] getPowers(){
		Integer[] tempPowers = new Integer[this.length];
		
		for(int i=0; i < this.length; i++){
			tempPowers[i] = this.powers[i];
		}
		return tempPowers;
	}
	public int degree(){
		return this.degree;
	}
	public int length(){
		
		return this.length;
	}
	
	public Integer[] getCoeffs(){
		Integer[] tempCoeffs = new Integer[this.length];
		
		for(int i=0; i < this.length; i++){
			tempCoeffs[i] = this.coefficients[i];		
			}
		return tempCoeffs;
	}
	
	public static Poly multiplyPoly(Poly p1, Poly p2){
		
		int p1Degree = p1.degree();
		int p2Degree = p2.degree();
		int p1Length = p1.length();
		int p2Length = p2.length();
		
		Integer[] p1Powers = p1.getPowers();
		Integer[] p1Coeffs = p1.getCoeffs();
		Integer[] p2Powers = p1.getPowers();
		Integer[] p2Coeffs = p1.getCoeffs();
		
		int newLength = p1Degree + p1Degree + 1;
		
		Integer[] newP1 = new Integer[p1Degree + 1];
		Integer[] newP2 = new Integer[p2Degree + 1];
		Integer[] newCoeffs = new Integer[newLength];
		
		for(int i=0; i < p1Length; i++){
			newP1[p1Powers[i]] = p1Coeffs[i];
		}
		
		for(int i=0; i < p2Length; i++){
			newP2[p2Powers[i]] = p2Coeffs[i];
		}
		
		for(int i=0;i<newLength;i++)
		{
			newCoeffs[i] = 0;
		}
		
		for (int i=0; i<p1Degree+1; i++) 
		{ 
		  for (int j=0; j<p2Degree+1; j++) 
			  newCoeffs[i + j] += newP1[i]*newP2[j]; 
		} 
		HashMap<Integer,Integer> answerMap = new HashMap<Integer,Integer>();

		for(int i=0; i < newLength; i++){
			answerMap.put(i,newCoeffs[i]);
		}
		
		Poly p = new Poly(answerMap);
		return p;
	}
	public static Poly addPoly(Poly p1, Poly p2){
				
		Integer[] p1Powers = p1.getPowers();
		int p1Degree = p1.degree();
		int p2Degree = p2.degree();
		int p1Length = p1.length();
		int p2Length = p2.length();
		Integer[] p1Coeffs = p1.getCoeffs();
		Integer[] p2Powers = p1.getPowers();
		Integer[] p2Coeffs = p1.getCoeffs();
		int newDegree = p1Degree > p2Degree?p1Degree:p2Degree;
		Integer[] newCoeffs = new Integer[newDegree+1];
		Integer[] newPowers = new Integer[newDegree+1];
		
		int i = 0, j = 0,k= 0;
		while(i < p1Length && j < p2Length){
			if(p1Powers[i] == p2Powers[j]){
				newCoeffs[k] = p1Coeffs[i] + p2Coeffs[j];
				newPowers[k] = i;
				i++;j++;k++;
			}
			else if(p1Powers[i] < p2Powers[j]){
				newCoeffs[k] = p1Coeffs[i];
				newPowers[k] = i;
				i++;k++;
			}else{
				newCoeffs[k] = p2Coeffs[j];
				newPowers[k] = j;
				j++;k++;
			}
		}
		
		while(i < p1Length){
			newCoeffs[k] = p1Coeffs[i];
			newPowers[k] = i;
			i++;k++;
		}
		while(j < p2Length){
			newCoeffs[k] = p2Coeffs[j];
			newPowers[k] = j;
			j++;k++;
		}
		
		HashMap<Integer,Integer> answerMap = new HashMap<Integer,Integer>();
		
		for(int p = 0; p <= newDegree; p++){
			answerMap.put(newPowers[p],newCoeffs[p]);
		}
		
		Poly p = new Poly(answerMap);
		return p;
		
	}
	
	public static void main(String args[]){
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		hmap.put(0, 1);
		hmap.put(1, 2);
		hmap.put(2, 3);	
		
		Poly p1 = new Poly(hmap);
		Poly p2 = new Poly(hmap);
		
		Poly p	= Poly.multiplyPoly(p1, p2);
		Integer [] temp = p.getCoeffs();
		System.out.println(temp[0]);
	}


}
