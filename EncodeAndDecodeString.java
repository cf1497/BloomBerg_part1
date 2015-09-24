package Algorithm_Part1;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("");
		list.add("sky");
		list.add("is");
		list.add("3#");
		list.add("123");
		list.add("1234567890123");
		
		//System.out.println(encode(list));
		String s = encode(list);
		System.out.println(s);
		List<String> decodeList = decode(s);
		System.out.println(decodeList);
		
		

	}
	
	public static String encode(List<String> list){
		StringBuilder sb = new StringBuilder();
		if(list.size()==0 || list==null) return sb.toString();
		
		for(int i=0; i<list.size(); i++){
			sb.append(list.get(i).length());
			sb.append("#");
			sb.append(list.get(i));
		}
		
		return sb.toString();
	}
	
	public static List<String> decode(String s){
			List<String> result = new ArrayList<String>();
			
			if(s.length()==0 || s==null) return result;
			
			int i=0;
			while(i<s.length()){
				StringBuilder lenStr= new StringBuilder();
				while(Character.isDigit(s.charAt(i))){			
					lenStr.append(s.charAt(i));
					i++;
				}
				
				int len = Integer.parseInt(lenStr.toString());
				
				String cur = s.substring(i+1,i+1+len);
				result.add(cur);
				i=i+1+len;
			}
			
			return result; 
	}
	
}

















