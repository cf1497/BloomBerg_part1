package Algorithm_Part1;

public class FindPeakNumber {
	
	public static void main(String[] args){
		int[] nums = {1,2,1};
		System.out.println(findPeakElementI(nums));
		System.out.println(findPeakElementII(nums));
		
	}
	
	public static int findPeakElementI(int[] nums) {
        
        if(nums.length==0){
            return -1;
        }
        
        if(nums.length==1){
            return 0;
        }
        
        if(nums[0]>nums[1]){
            return 0;
        }
        
        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        
        for(int i=1; i<nums.length-1; i++){
             if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                 return i;
             }
        }
        
        return -1;
    }
	
	public static int findPeakElementII(int[] nums){
		int start = 0, end = nums.length-1;
		while(start<end){
		    int mid =(start+end)/2;
		    if(nums[mid]<nums[mid+1]){
		    	start = mid+1;
		    }else{
		    	end = mid;
		    }
		}
		
		return start;
		
	}

}
