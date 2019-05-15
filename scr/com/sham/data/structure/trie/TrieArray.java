package com.sham.data.structure.trie;

public class TrieArray {
	
	class TrieNode {
		TrieNode[] children;
		boolean isEnd;
		// Initialize your data structure here.
		public TrieNode() {
			this.children = new TrieNode[26];
		}
	}
	
	private TrieNode root;

	public TrieArray() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode tempRoot = root;
		for(char ch : word.toCharArray()){
			int index = ch - 'a';
			if(tempRoot.children[index] == null){
				TrieNode temp = new TrieNode();
				tempRoot.children[index] = temp;
				tempRoot = temp;
			}else{
				tempRoot = tempRoot.children[index];
			}
		}
		tempRoot.isEnd=true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode node = searchNode(word);
		if(node==null){
			return false;
		}else{
			if(node.isEnd)
				return true;
		}

		return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode node = searchNode(prefix);
		if(node==null){
			return false;
		}else{
			return true;
		}
	}

	public TrieNode searchNode(String s){
		TrieNode tempRoot = root;
		for(char ch : s.toCharArray()){
			int index = ch - 'a';
			if(tempRoot.children[index] != null){
				tempRoot = tempRoot.children[index];
			}else{
				return null;
			}
		}
		if(tempRoot == root)
			return null;
		return tempRoot;
	}
	
	public String getMatchingPrefix(String string){
		String prefix = "";
		StringBuffer strBuf = new StringBuffer();
		TrieNode tempRoot = root;
		for(char ch : string.toCharArray()){
			int index = ch - 'a';
			if(tempRoot.children[index] != null){
				tempRoot = tempRoot.children[index];
				strBuf.append((char)('a' + index));
				if(tempRoot.isEnd){
					prefix = strBuf.toString();
				}
			}else{
				break;
			}
		}
		return prefix;
	}
	
	public static void main(String[] args) {
		TrieArray dict = new TrieArray();
		dict.insert("are");
		dict.insert("area");
		dict.insert("base");
		dict.insert("cat");
		dict.insert("cater");
		dict.insert("basement");

		System.out.println(dict.getMatchingPrefix("cateasd"));
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