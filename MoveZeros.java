package Algorithm_Part1;

public class MoveZeros {
	
	public static void main(String[] args){
		int[] nums = {0,1,2,0,0,3,5,0,6,0,0,0,12};
		moveZeros(nums);
		
		for(int n:nums){
			System.out.print(n+" ");
		}
	}
	
	public static void moveZeros(int[] nums){
		if(nums.length==0) return ;
		
		int start = 0;
		int index = 0;
		
		while(index<nums.length){
			if(nums[index]!=0){
				swap(nums,start,index);
				start++;
			}
			index++;
		}
	}
	
	public static void swap(int[] nums, int a, int b){
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	
	
}
