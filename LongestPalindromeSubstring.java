package Algorithm_Part1;

public class LongestPalindromeSubstring {

	public static void main(String[] args){
		String s = "dabac";
		System.out.println(getPalindromeII(s));
		
	}
	
	//method 1 : Using '#', O(n)
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
	
	//method2: O(n^2)
	
	public static String getPalindromeII(String s){
		
		if(s==null || s.length()==0){
			return s;	
		}
		
		String result = "";
		
		for(int i=0; i<s.length(); i++){
			String cur = helper(s,i,i);
			if(cur.length()>result.length()){
				result = cur;
			}
			
			cur = helper(s,i,i+1);
			if(cur.length()>result.length()){
				result = cur;
			}
			
		}
		
		return result;
	}
	
	public static String helper(String s, int start, int end){
		
		while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
			start--;
			end++;
		}
		
		return s.substring(start+1, end);
	}
}
























