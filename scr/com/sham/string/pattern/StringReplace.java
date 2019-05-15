package com.sham.string.pattern;

import java.util.concurrent.Delayed;

public class StringReplace {

	public String removeMultiChar(String string){
		
		if(string == null || string!= null && string.trim().length() == 0){
			return string;
		}
		StringBuilder strBuf = new StringBuilder();
		char charArr[] = string.toCharArray();
		char prev = 0;
		for(int index=0; index<charArr.length;index++){
			if(index == 0){
				prev = charArr[index];
				strBuf.append(prev);
			}else{
				if(prev != charArr[index]){
					prev = charArr[index];
					strBuf.append(prev);
				}
			}
		}
		return strBuf.toString();
	}
	
	public String removeMultiCharToNum(String string){
		
		if(string == null || string!= null && string.trim().length() == 0){
			return string;
		}
		StringBuilder strBuf = new StringBuilder();
		StringBuilder strFinal = new StringBuilder();
		char charArr[] = string.toCharArray();
		char prev = 0;
		for(int index=0; index < charArr.length;index++){
			if(index == 0){
				prev = charArr[index];
				strBuf.append(prev);
			}else{
				if(prev != charArr[index]){
					strFinal.append(formatToNum(strBuf.toString()));
					strBuf.delete(0, strBuf.length());
					prev = charArr[index];
					strBuf.append(prev);
				}else{
					strBuf.append(prev);
				}
			}
		}
		strFinal.append(formatToNum(strBuf.toString()));
		return strFinal.toString();
	}
	
	
	public String formatToNum(String string){
		StringBuffer strBuf = new StringBuffer();
		if(string.length() > 1){
			for(int index = 0; index < string.length() / 9; index++)
				strBuf.append("9" + string.charAt(0));
			strBuf.append(string.length()%9 +"" + string.charAt(0));
		}else{
			strBuf.append(string);
		}
		return strBuf.toString();
	}
	public static void main(String args[]){
		StringReplace strRep = new StringReplace();
		System.out.println(strRep.removeMultiCharToNum("daaabbcdeeeeeeeeeeeeeeeef"));
	}
}
