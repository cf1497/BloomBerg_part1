package Algorithm_Part1;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,3,5};
		System.out.println(missingNumberBinarySearch(nums));

	}
	
	// array is sorted
	public static int missingNumber(int[] nums){
		int result = -1;
		if(nums[0]!=0) return 0;
		
		for(int i=1; i<nums.length; i++){
			if(nums[i]-nums[i-1]!=1){
				result =  nums[i]-1;
			}
		}
		
		return result;
	}
	
	//array is unsorted
	public static int missingNumberII(int[] nums){
		boolean[] bool = new boolean[nums.length+1];
		for(int i=0; i<nums.length; i++){
			bool[nums[i]] = true;
		}
		int result = -1;
		for(int i=0; i<bool.length; i++){
			if(!bool[i]) result = i; 
		}
		
		return result;
	}
	
	//array is unsorted, using math
	public static int missingNumberIII(int[] nums){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i=0; i<nums.length; i++){
			sum+=nums[i];
			max = Math.max(max,nums[i]);
			min = Math.min(min, nums[i]);
		}
		
		
		return (max+0)*(max+1)/2 - sum;
	}
	
	public static int missingNumberBit(int[] nums){
		int result = 0;
		for(int i=0; i<nums.length; i++){
			result^=(i+1)^nums[i];
		}
		return result;
	}
	
	// array is sorted, using binary-search
	public static int missingNumberBinarySearch(int[] nums){
		
		return binaryS(nums,0,nums.length-1);
		
	}
	
	public static int binaryS(int[] nums, int start, int end){
		if(start>=end){
			return -1;
		}
		
		int mid = (start+end)/2;
		if(nums[mid+1]-nums[mid]==2){
			return nums[mid]+1;
		}
		
		int result = 0;
		result = binaryS(nums,start,mid-1);
		if(result==-1){
			result = binaryS(nums,mid+1,end);
		}
		
		return result;
	}

}






















