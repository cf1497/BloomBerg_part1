package Algorithm_Part1;

public class palindromeNumber {
	public static void main(String[] args){
		
		//System.out.println(palindrome(x));
		int x=3;
		System.out.println(count(x));
	}
	
	public static int count(int digit){
		
		int start = (int) Math.pow(10, digit-1);
		int end = (int) Math.pow(10, digit);
		
		int count = 0;
		for(int i=start; i<end; i++){
			if(palindrome(i)){
				count++;
				System.out.println(i);
			}
		}
		
		return count;
	}
	
	public static boolean palindrome(int x){
		int sum = 0;
		int copy = x;
		while(copy>0){
			 sum = sum*10 + copy%10;
			 copy=copy/10;
		}
		
		return x==sum;
	}
}
