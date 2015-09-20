package Algorithm_Part1;

public class LongestPalindromeSubstring {

	public static void main(String[] args){
		String s = "dabac";
		System.out.println(getPalindrome(s));
		
	}
	
	public static String getPalindrome(String s){ 
		
		if(s==null || s.length()==0){
			return s;
		}
		
		String result = "";
		for(int i=1; i<2*s.length(); i++){
			int count = 1;
			while(i-count>=0 && i+count<=2*s.length() && getChar(s,i-count) == getChar(s,i+count)){
				count++;	
			}
			count--;
			if(count>result.length()){				
				result = s.substring((i-count)/2, (i+count)/2);
			}
		}
		
		return result;
	}
	
	public static char getChar(String s, int i){
		if(i%2==0){
			return '#';	
		}else{
			return s.charAt(i/2);
		}
	}
}
