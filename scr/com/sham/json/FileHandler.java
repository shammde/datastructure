package com.sham.json;

import java.io.InputStream;

public class FileHandler {

	public static InputStream inputStreamFromFile(String path){
		
		try{
			return FileHandler.class.getResourceAsStream(path);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
