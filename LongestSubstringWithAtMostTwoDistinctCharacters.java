package Algorithm_Part1;

import java.util.HashMap;

public class LongestSubstringWithAtMostTwoDistinctCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cabb";
		System.out.println(lengthOfDistinct(s));
	}
	
	//method1: B-force with hashmap
	public static int lengthOfDistinct(String s){
		if(s.length()==0 || s==null){
			return 0;
		}
		
		int max = 0;
		
		int pos =0, left=0;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		while(pos<s.length()){
			char c = s.charAt(pos);
			if(map.containsKey(c)){
				map.put(c,map.get(c)+1);
			}else{
				map.put(c,1);
				while(map.size()>2){
					char leftChar = s.charAt(left);
					if(map.get(leftChar)==1){
						map.remove(leftChar);
					}else{
						map.put(leftChar, map.get(leftChar)-1);
					}
					left++;
				}
			}
			max = Math.max(max, pos-left+1);
			pos++;
		}
		
		return max;
	}

}
