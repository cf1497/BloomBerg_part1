package Algorithm_Part1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class PrintNumbersByFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,1,1,6,6,9,9,9};
		for(int n : printByFrequency(nums)){
			System.out.print(n+" ");
		}
	}
	
	public static List<Integer> printByFrequency(int[] nums){
		List<Integer> result = new ArrayList<Integer>();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int n:nums){
			if(map.containsKey(n)){
				map.put(n, map.get(n)+1);
			}else{
				map.put(n,1);
			}
		}
		
//		HashMap<Integer,ArrayList<Integer>> list = new HashMap<Integer,ArrayList<Integer>>();
//		
//		for(int n :map.keySet()){
//			if(list.containsKey(map.get(n))){
//				list.get(map.get(n)).add(n);
//			}else{
//				ArrayList<Integer> tmp = new ArrayList<Integer>();
//				tmp.add(n);
//				list.put(map.get(n),tmp);
//			}
//		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){

			@Override
			public int compare(Integer a, Integer b) {
				
				if(map.get(a) == map.get(b)){
					return b-a;
				}
				
				return map.get(b)-map.get(a);
			}
		}); 
		
		for(int n: map.keySet()){
			queue.offer(n);
		}
		
		while(!queue.isEmpty()){
			int cur = queue.poll();
			while(map.get(cur)>0){
				result.add(cur);
				map.put(cur,map.get(cur)-1);
			}
		}
		
		
		return result;
	}

}
