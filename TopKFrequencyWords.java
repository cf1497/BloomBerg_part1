package Algorithm_Part1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequencyWords {
	
	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("d");
		
		
		System.out.println(findWords(list,2));
		
	}
	
	public static List<String> findWords(List<String> dict, int k){
		List<String> result = new ArrayList<String>();
		
		if(dict.size()==0) return result;
		
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		
		for(String str : dict){
			if(map.containsKey(str)){
				map.put(str, map.get(str)+1);
			}else{
				map.put(str,1);
			}
		}
		
		
		
		PriorityQueue<String> queue = new PriorityQueue<String>(dict.size(), new Comparator<String>(){
		
			public int compare(String s1, String s2){
				return map.get(s2)-map.get(s1);
			}
		});
		
		for(String str: map.keySet()){
			queue.add(str);
		}
		
      
       while(k>0){
    	   result.add(queue.poll());
    	   k--;
       }
		
		return result;
	}

}
