package Algorithm_Part1;
import java.util.HashMap;
import java.util.Map;

import data.TrieNode;

public class WordDictionary {
	
	public static void main(String[] args){
		WordDictionary dict = new WordDictionary();
		dict.addWord("bb");
//		dict.addWord("dad");
//		dict.addWord("mad");
		
		System.out.println(search(".."));
//		System.out.println(search("bad"));
//		System.out.println(search(".ad"));
//		System.out.println(search("b.."));
		
	}
	
	private static TrieNode root = null;
	
	public WordDictionary(){
		root = new TrieNode();
	}

    // Adds a word into the data structure.
    public static void addWord(String word) {
        HashMap<Character, TrieNode> children = root.children;
        
        for(int i=0; i<word.length(); i++){
        	char c = word.charAt(i);
        	TrieNode t = null;
        	if(children.containsKey(c)){
        		t =  children.get(c);
        	}else{
        		t = new TrieNode(c);
        		children.put(c, t);
        	}
        	
        	children = t.children;
        	
        	if(i==word.length()-1) t.isLeaf = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public static boolean search(String word) {
    	
    	return dfs(root.children,word,0);
    	
    }
    
    public static boolean dfs(HashMap<Character,TrieNode> children, String word,int pos){
      	
    	if(pos>=word.length()) return false;
    	
    	char c = word.charAt(pos);
    	
    	
    	if(children.containsKey(c)){
    		if(pos == word.length()-1 && children.get(c).isLeaf) return true;
    		
    		return dfs(children.get(c).children,word,pos+1);
    	}
    	
    	else if(c=='.'){
    		boolean result = false;
    		for(char key : children.keySet()){
    			if(pos == word.length()-1 && children.get(key).isLeaf){
    				return true;
    			}
    			
    			if(dfs(children.get(key).children, word, pos+1)){
    				result = true;
    			}
    		}
    		return result;
    	}
    	
    	else{
    		return false;
    	}
    }
    		
   
}
   












