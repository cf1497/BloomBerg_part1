package Algorithm_Part1;
import data.TrieNode;
import java.util.*;

public class Trie {
	public static void main(String[] args){
		Trie trie = new Trie();
		trie.insert("cat");
		trie.insert("cctv");
		
		System.out.println(trie.search("cat"));
		System.out.println(trie.search("tra"));
		System.out.println(trie.startsWith("cc"));
		
	}
	
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	HashMap<Character, TrieNode> children = root.children;
    	for(int i=0; i<word.length(); i++){
    		char c = word.charAt(i);
    		TrieNode t = null;
    		if(children.containsKey(c)){
    			t = children.get(c);
    		}else{
    			t = new TrieNode(c);
    			children.put(c, t);
    		}
    		
    		if(i==word.length()-1) t.isLeaf = true;
    		
    		children = t.children;
    	}
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	
    	TrieNode t = searchNode(word);
    	
    	if(t!=null && t.isLeaf){
    		return true;
    	}
		
    	return false;
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode t = searchNode(prefix);
    	
    	if(t!=null) return true;
		
    	return false;
        
    }
    
    public TrieNode searchNode(String str){
    	
    	HashMap<Character, TrieNode> children = root.children;
    	TrieNode t = null;
    	for(int i=0; i<str.length(); i++){
    		char c  =str.charAt(i);
    		if(children.containsKey(c)){
    			t = children.get(c);
    		}else{
    			return null;	
    		}
    		children = t.children;
    	}
    	
    	return t;
    }
}



















