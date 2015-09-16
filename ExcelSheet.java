package Algorithm_Part1;

public class ExcelSheet {
	public static void main(String[] args){
		int n=731;
		System.out.println(ExcelColTitle(n));
		System.out.println(ExcelColNum("ABC"));
	}
	
	// 1->A, 2->B, 27->AA, 28->AB,29->AC
	public static String ExcelColTitle(int n){
		StringBuilder sb = new StringBuilder();
		
		while(n>0){
			n--;
			sb.insert(0, (char)('A'+n%26));
			n=n/26;
		}
		
		
		return sb.toString();
	}
	
	// reverse the upper case
	public static int ExcelColNum(String str){
		if(str==null || str.length()==0){
			return 0;
		}
		
		int sum = 0;
		
		for(int i=0; i<str.length(); i++){
			char cur = str.charAt(i);
			int digit = str.length()-1-i;
			sum+=(int)(Math.pow(26, digit))*(cur-'A'+1);
		}
		
		return sum;
	}
}
