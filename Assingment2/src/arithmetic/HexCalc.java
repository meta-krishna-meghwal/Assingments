package arithmetic;

public class HexCalc {
	private static int base = 16;
	
	public int hexToDec(String hexString){
		int decimal = Integer.parseInt(hexString,base); 
		return decimal;
	}
	
	public String decToHex(int decimal){
		String hexString = Integer.toHexString(decimal); 
		return hexString;
	}
	
	public String hexAddition(String number1,String number2){
		String answer = "";
		int num1 = this.hexToDec(number1);
		int num2 = this.hexToDec(number2);
		
		answer = this.decToHex(num1 + num2);
		return answer;
	}
	public String hexSubstraction(String number1,String number2){
		String answer = "";
		int num1 = this.hexToDec(number1);
		int num2 = this.hexToDec(number2);
		
		answer = this.decToHex(num1 - num2);
		return answer;
	}
	public String hexMultiplication(String number1,String number2){
		String answer = "";
		int num1 = this.hexToDec(number1);
		int num2 = this.hexToDec(number2);
		
		answer = this.decToHex(num1 * num2);
		return answer;
	}
	public String hexDivision(String number1,String number2){
		String answer = "";
		int num1 = this.hexToDec(number1);
		int num2 = this.hexToDec(number2);
		
		answer = this.decToHex(num1 / num2);
		return answer;
	}
	
	public boolean lessThan(String number1,String number2){
		
		boolean answer = false;		
		if(number1.length()  < number2.length()){
			answer = true;
		}else if(number1.length() > number2.length()){
			answer = false;
		}else{
			int n = number1.length();
			for(int i=0;i<n;i++){
				if(number1.charAt(i) < number2.charAt(i)){
					answer = true;
					break;
				}else if(number1.charAt(i) > number2.charAt(i)){
					answer = false;
					break;
				}
			}
		}
		return answer;
	}
	public boolean greaterThan(String number1,String number2){
		boolean answer = false;
		
		if(number1.length()  > number2.length()){
			answer = true;
		}else if(number1.length() < number2.length()){
			answer = false;
		}else{
			int n = number1.length();
			
			for(int i=0;i<n;i++){
				if(number1.charAt(i) > number2.charAt(i)){
					answer = true;
					break;
				}else if(number1.charAt(i) < number2.charAt(i)){
					answer = false;
					break;
				}
			}
		}
		return answer;
	}
	public boolean equalsTo(String number1,String number2){		
		return number1.equals(number2);
	}
	public static void main(String[] args){
		
		HexCalc h = new HexCalc();
		
		System.out.println(h.lessThan("abcd","bcd"));
	}
	
	

}
