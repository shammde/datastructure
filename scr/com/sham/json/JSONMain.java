package com.sham.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONMain {
	
	public static void main(String args[]){
		
		JSONObject jObj = JSONUtils.getJSONObjectFromFile("/com/sham/json/first.json");
		String names[] = JSONObject.getNames(jObj);
		System.out.println(jObj);
		for(String name : names){
			try {
				System.out.println(name + ": " + jObj.get(name));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 
		 */
		try{
		JSONObject obj = new JSONObject();
		obj.put("Name", "crunchify.com");
		obj.put("Author", "App Shah");
 
		JSONArray company = new JSONArray();
		company.put("Compnay: eBay");
		company.put("Compnay: Paypal");
		company.put("Compnay: Google");
		obj.put("Company List", company);
		System.out.println(obj.toString());
		}catch(Exception e){}
		
		// try-with-resources statement based on post comment below :)
		/*try (FileWriter file = new FileWriter("/Users/<username>/Documents/file1.txt")) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}*/
		
	}
}
