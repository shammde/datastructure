package com.sham.data.structure.trie;

public class XORArray {
	
	public static void main(String args[]){
		new XORArray().print100(1);
	}
	public void print100(int index){
		if(index <= 100){
			print100(index+1);
			System.out.println(index);
		}
	}
}