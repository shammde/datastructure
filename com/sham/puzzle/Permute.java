package com.sham.puzzle;

public class Permute {



	public static void main(String args[]){

		for(String str : permute("123")){
			System.out.println(str);
		}
	}


	public static int factorial(int n){
		if(n == 0){
			return 1;
		}
		return n * factorial(n -1);
	}
	public static String[] permute(String str){

		String result [] = new String[factorial(str.length())];
		int resultIndex = 0;
		if(str.length() == 1){
			result[resultIndex] = str;
			return result;
		}

		for(int index = 0; index < str.length(); index++){
			char ch = str.charAt(index);
			String temp[] = permute(str.substring(0, index) + str.substring(index+1, str.length()));
			for(int i = 0; i < temp.length; i++){
				result[resultIndex++] = ch + temp[i];
			}
		}
		return result;
	}
}
