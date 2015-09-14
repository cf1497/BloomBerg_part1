package Algorithm_Part1;

public class KthLargestNumber_QuickSort {
	
	public static void main(String[] args){
	     int[] nums = {4,3,2,5,7,1,8,6};
	     System.out.println(findKthLargest(nums,7));
	}
	
	public static int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}
	 
		return getKth(nums.length - k +1, nums, 0, nums.length - 1);
	}
	 
	public static int getKth(int k, int[] nums, int start, int end) {
		int left = start;
		int right = end;
		
		int pivot = nums[end];
		
		while(left<right){
			
			while(nums[left]<pivot && left<right){
				left++;
			}
			
			while(nums[right]>=pivot&& left<right){
				right--;
			}
			
			swap(nums, left , right);
		}
		
		swap(nums, left, end);
		
		if(k==left+1){
			return pivot;
		}else if(k<left+1){
			return getKth(k,nums,start,left-1);
		}else{
			return getKth(k,nums,left+1, end);
		}
		
	}
	 
	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
}
