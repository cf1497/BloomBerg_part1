package Algorithm_Part1;
import java.util.*;

public class Roman {
	
	public static void main(String[] args){
		System.out.println(romanToInt("IIIV"));
		System.out.println(intToRoman(6));
	}
	
	public static int romanToInt(String s){
		
		if(s==null || s.length()==0){
			return 0;
		}
		
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		char[] schar = s.toCharArray();
		int sum = map.get(schar[0]);
		for(int i=0; i<schar.length-1; i++){
			if(map.get(schar[i])>=map.get(schar[i+1])){
				sum+=map.get(schar[i+1]);
			}else{
				sum+= map.get(schar[i+1])-2*map.get(schar[i]);
			}
		}
		
		return sum;
	}
	
	public static String intToRoman(int n){
		int[] aArray = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] rArray={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<aArray.length; i++){
			while(n>=aArray[i]){
				sb.append(rArray[i]);
				n-=aArray[i];
			}
		}
		
		return sb.toString();
		
		
		
	}

}
