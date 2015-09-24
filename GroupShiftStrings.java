package Algorithm_Part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupShiftStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = {"abc","bcd","acef","xyz","az","ba","a","z","cbg","dx"};
		System.out.println(groupStrings(strings));
	}
	
	public static List<List<String>> groupStrings(String[] strings){
		List<List<String>> list = new ArrayList<List<String>>();
		HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		for(String str : strings){
			int offset = str.charAt(0)-'a';
			String key = "";
			for(int i=0; i<str.length(); i++){
				char c = str.charAt(i);
				c=(char) (c-offset);
				if(c<'a') c+=26;
				key+=c;
			}
			if(!map.containsKey(key)){
				ArrayList<String> tmp = new ArrayList<String>();
				tmp.add(str);
				map.put(key, tmp);
			}else{
			map.get(key).add(str);
			}
		}
		
		for(ArrayList<String> cur : map.values()){
			Collections.sort(cur);
			list.add(cur);
		}
		
		return list;
	}

}
