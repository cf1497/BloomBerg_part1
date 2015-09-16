package Algorithm_Part1;

public class NextPermutation {
	public static void main(String[] args){
		int[] nums = {1,2};
		nextPermutation(nums);
		System.out.println();
		System.out.println("result: ");
		for(int n: nums){
			System.out.print(n+" ");
		}
	}
	
	public static void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return;
        }
        
        //find the first down point from the end to start
        int p = nums.length-2;
        
        while(p>=0){
            if(nums[p]<nums[p+1]){
                break;
            }
            p--;
        }
        
        
        if(p==-1){
            reverseArray(nums, 0 ,nums.length-1);
            return;
        }
        
        //find the mimnum element after the down point
        int i=0;
        System.out.println(p);
        for( i=p+1; i<nums.length; i++){
            if(nums[i]<=nums[p]){
            	System.out.println("Enter");
                int tmp = nums[i-1];
                nums[i-1] = nums[p];
                nums[p]=tmp;
                break;
            }
            
            if(i==nums.length-1){
            int tmp = nums[i];
            nums[i] = nums[p];
            nums[p]=tmp;
            }
            
        }
        
        
        System.out.println("Test: ");
        for(int n: nums){
        	
			System.out.print(n+" ");
		}
        
        //reverse the elements after down point
        reverseArray(nums,p+1,nums.length-1);
        return;
        
    
    }
    
    public static void reverseArray(int[] nums, int start, int end){
        while(start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = nums[start];
            start++;
            end--;
        }
    }
}
