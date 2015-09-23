package Algorithm_Part1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInDataStream {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		System.out.println("Median: "+findMedian(nums));
	}
	
	public static int findMedian(int[] nums){
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b){
				return b-a;
			}

		});
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		int median = nums[0];
		
		for(int i=1; i<nums.length; i++){
			int cur = nums[i];
			if(cur<median){
				maxHeap.offer(cur);
			}else{
				minHeap.offer(cur);
			}
			
			if(maxHeap.size()>minHeap.size()){
				minHeap.offer(median);
				median = maxHeap.poll();
			}else if(maxHeap.size()+1<minHeap.size()){
				maxHeap.offer(median);
				median = minHeap.poll();
			}
		}
		
		return median;
	}

}
