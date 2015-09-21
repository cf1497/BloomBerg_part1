package Algorithm_Part1;

public class ShortestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "baa";
		System.out.println(shortestPalindromeBack(s));

	}
	
	public static String shortestPalindrome(String s){
		
		if(s==null || s.length()==0){
			return s;
		}
		
		int i=0;
		for(int j=s.length()-1; j>=0; j--){
			if(s.charAt(i)==s.charAt(j)){
				i++;	
			}
			
		}
		
		if(i==s.length()){
			return s;
		}
		
		String suffix = s.substring(i);
		String prefix  = new StringBuilder(suffix).reverse().toString();
		String mid = shortestPalindrome(s.substring(0, i));
		
		
		return prefix+mid+suffix;
	}
	
	public static String shortestPalindromeBack(String s){
		if(s==null || s.length()==0){
			return s;
		}
		
		int j=s.length()-1;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)==s.charAt(j)){
				j--;
			}
		}
		
		if(j==-1){
			return s;
		}
		
		String prefix = s.substring(0,j+1);
		String suffix = new StringBuilder(prefix).reverse().toString();
		String mid = shortestPalindromeBack(s.substring(j+1));
		
		return prefix+mid+suffix;
	}

}
















