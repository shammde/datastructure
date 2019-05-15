package com.sham.data.structure.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieMap {
	
	class TrieNode {
		char c;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isLeaf;
		public TrieNode() {}
		public TrieNode(char c){
			this.c = c;
		}
	}
	
	private TrieNode root;

	public TrieMap() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		HashMap<Character, TrieNode> children = root.children;
		for(int i=0; i<word.length(); i++){
			char c = word.charAt(i);
			TrieNode temp;
			if(children.containsKey(c)){
				temp = children.get(c);
			}else{
				temp = new TrieNode(c);
				children.put(c, temp);
			}
			children = temp.children;
			//set leaf node
			if(i==word.length()-1)
				temp.isLeaf = true;    
		}
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode t = searchNode(word);
		if(t != null && t.isLeaf) 
			return true;
		else
			return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if(searchNode(prefix) == null) 
			return false;
		else
			return true;
	}

	public TrieNode searchNode(String str){
		Map<Character, TrieNode> children = root.children; 
		TrieNode temp = null;
		for(char ch : str.toCharArray()){
			if(children.containsKey(ch)){
				temp = children.get(ch);
				children = temp.children;
			}else{
				return null;
			}
		}
		return temp;
	}

	public String getMatchingPrefix(String string){
		String prefix = "";
		StringBuffer strBuf = new StringBuffer();
		TrieNode tempRoot = root;
		for(char ch : string.toCharArray()){
			if(tempRoot.children.containsKey(ch)){
				tempRoot = tempRoot.children.get(ch);
				strBuf.append(ch);
				if(tempRoot.isLeaf){
					prefix = strBuf.toString();
				}
			}else{
				break;
			}
		}
		return prefix;
	}
	
	public static void main(String[] args) {
		TrieMap dict = new TrieMap();
		dict.insert("are");
		dict.insert("area");
		dict.insert("base");
		dict.insert("cat");
		dict.insert("cater");
		dict.insert("basement");

		String input = "caterer";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));              

		input = "basement";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));                      

		input = "are";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));              

		input = "arex";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));              

		input = "basemexz";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));                      

		input = "xyz";
		System.out.print(input + ":   ");
		System.out.println(dict.getMatchingPrefix(input));
	}
}