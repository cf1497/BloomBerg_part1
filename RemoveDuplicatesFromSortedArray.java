package Algorithm_Part1;

public class RemoveDuplicatesFromSortedArray {
	
	public static void main(String[] args){
		int[] nums={1,1,2,2,3,4,5,5,6};
		System.out.println(removeDuplicates(nums));
		
		for(int n:nums){
			System.out.print(n+ " "); 
		}
	}
	
	public static int removeDuplicates(int[] nums){
		if(nums.length==0 || nums.length==1){
			return nums.length;
		}
		
		int start = 0, p = 1;
		
		while(p<nums.length){
			if(nums[p]==nums[start]){
				p++;
			}else{
				start++;
				nums[start] = nums[p];
				p++;
			}
		}
		
		return start+1;
	}
}
