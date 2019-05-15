package com.sham.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONMain {
	
	public static void main(String args[]){
		
		JSONObject jObj = JSONUtils.getJSONObjectFromFile("/com/sham/json/first.json");
		String names[] = JSONObject.getNames(jObj);
		System.out.println(jObj.toString(2));
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
		obj.put("Name", "sham.com");
		obj.put("Author", "Ehtesham");
 
		JSONArray company = new JSONArray();
		company.put("Compnay: hello");
		company.put("Compnay: hi");
		company.put("Compnay: welcomne");
		obj.put("Company List", company);
		System.out.println(obj.toString(5));
		}catch(Exception e){}
		
		// try-with-resources statement based on post comment below :)
		/*try (FileWriter file = new FileWriter("/Users/<username>/Documents/file1.txt")) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}*/
		
	}
}
