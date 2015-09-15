package Algorithm_Part1;

public class QuickSort {
      
	public static void main(String[] args){
		int[] nums = {4,3,2,5,6,1,7};
		
		quickSort(nums);
		for(int n:nums){
			System.out.print(n+" ");
		}
	}
	
	public static void partition(int[] nums, int start, int end){
		
		
		
		if(start>end){
			return;
		}
		
		int p = start;
		for(int i=start; i<=end; i++){
			if(nums[i]<nums[start]){
				p++;
				swap(nums,i,p);
			}
		}
		
		swap(nums,start,p);
		for(int n:nums){
			System.out.print(n+" ");
		}
		System.out.println();
		partition(nums,start,p-1);
		partition(nums,p+1,end);
	}
	
	public static void quickSort(int[] nums){
		partition(nums, 0, nums.length-1);
	}
	
	public static void swap(int[] nums, int a, int b) {
		// TODO Auto-generated method stub
       int tmp = nums[a];
       nums[a] = nums[b];
       nums[b] = tmp;
	}
}
