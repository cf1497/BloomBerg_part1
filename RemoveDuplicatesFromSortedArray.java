package Algorithm_Part1;

public class RemoveDuplicatesFromSortedArray {
	
	public static void main(String[] args){
		int[] nums={1,1,2,2,2,2,3,3,4,5,5,6};
		System.out.println(removeDuplicatesI(nums));
		
		for(int n:nums){
			System.out.print(n+ " "); 
		}
		
		System.out.println();
		
		System.out.println(removeDuplicatesII(nums));
		
		for(int n:nums){
			System.out.print(n+ " "); 
		}
	}
	
	public static int removeDuplicatesI(int[] nums){
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
	
	public static int removeDuplicatesII(int[] nums){
		if(nums.length<3){
			return nums.length;
		}
		
		int start = 0, p = 0;
		
		int count =1;
		
		while(p<nums.length){
			if(nums[start]==nums[p]){
				if(count==1){
					start++;
					nums[start]= nums[p];
				}
				p++;
				count++;
			}else{
				start++;
				nums[start] = nums[p];
				p++;
			}
		}
		
		return start+1;
		
	}
}
