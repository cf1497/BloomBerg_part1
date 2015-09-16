package Algorithm_Part1;

public class ReverseInteger {
	public static void main(String[] args){
		System.out.println(reverse(-123));
	}

	public static int reverse(int x) {
        boolean flag = x>=0? true:false;
        x= Math.abs(x);
        int y = 0;
        while(x>0){
            y = y*10 + x%10;
            x = x/10;
        }
        
        return flag==true? y :(-y);
    }
}
