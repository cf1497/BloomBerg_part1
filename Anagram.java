package Algorithm_Part1;
import java.util.*;

public class Anagram {
	
	public static void main(String[] args){
		String s = "cat";
		String t = "tca";
		String[] strs = {"cat", "tca","nda","cta","dan","cnd"};
		
		//System.out.println(isAnagram(s,t));
		
		List<List<String>> lists = new ArrayList<List<String>>();
		lists = anagramGroup(strs);
		System.out.println(lists);
	}
	
	
	//method1 : use HashMap, time: O(n)
	public static boolean isAnagram(String s, String t){
		
		if(s.length()!=t.length()) return false;
		
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		
		for(int i=0; i<s.length(); i++){
			if(map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			}else{
				map.put(s.charAt(i), 1);
			}
		}
		
		
		for(int i=0; i<t.length(); i++){
			char c = t.charAt(i);
			if(!map.containsKey(c)) return false;
			if(map.get(c)==0){
				return false;
			}else{
				map.put(c,map.get(c)-1);
			}
		}
		
		return true;
	}
	
	//methond2: use Sort Algorithm, O(lgn) ....
	
	//==========================================================================
	
	
	// Anagrams group
	
	public static List<List<String>> anagramGroup(String[] strs){
		List<List<String>> result = new ArrayList<List<String>>();
		
		int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 107};
		HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		
		for(int i=0; i<strs.length;i++){
			String cur = strs[i];
			int key = 1;
			for(int j=0; j<cur.length();j++){
				key *= primes[cur.charAt(j)-'a'];
			}
			
			List<String> list = map.get(key);
			
			if(list==null){
				list = new ArrayList<String>();
				list.add(cur);
				map.put(key, list);
			}else{
				list.add(cur);
			}
		}
		
		for(List<String> maplist : map.values()){
			result.add(maplist);
		}
		
		
		return result;
	}
	
	

}
