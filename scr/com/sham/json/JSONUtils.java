package com.sham.json;

import java.io.InputStream;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {

	
	public static String getJSONStringFromFile(String path){
		
		InputStream inputStream = FileHandler.inputStreamFromFile(path);
		Scanner scanner = new Scanner(inputStream);
		String json = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return json;
	}
	
	public static JSONObject getJSONObjectFromFile(String path){
		
		try {
			return new JSONObject(getJSONStringFromFile(path));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean isObjectExist(JSONObject jsonObject, String key){
		Object object = null;
		try{
			object = jsonObject.get(key);
		}catch(Exception e){
			return false;
		}
		return object != null;
	}
}
