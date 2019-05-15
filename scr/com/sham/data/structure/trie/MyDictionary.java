package com.sham.data.structure.trie;

import java.util.ArrayList;
import java.util.List;

public class MyDictionary {
	
	List<String> list = new ArrayList<String>();
	
	public MyDictionary(){
		list.add("are");
		list.add("area");
		list.add("base");
		list.add("cat");
		list.add("cater");
		list.add("children");
		list.add("basement");
	}
	
	public String isPrefix(String word){
		String str = null;
		StringBuffer strBuf = new StringBuffer();
		for(char ch : word.toCharArray()){
			strBuf.append(ch);
			if(list.contains(strBuf.toString())){
				str = strBuf.toString();
			}
		}
		return str;
	}
	
	public static void main(String args[]){
		System.out.println(new MyDictionary().isPrefix("childrendk"));
	}

}
