package co.bluecake.service.search;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class FoodDatabaseService {
	
	//https://api.edamam.com/api/food-database/parser?ingr=red%20apple&app_id={your app_id}&app_key={your app_key}
	
	private static final String FOOD_DATABASE_URL = 
			"https://api.edamam.com/api/food-database/parser";

	private static final String API_ID = "743f063f";
	private static final String API_KEY = "33927b9a35f73a555b704564c8ee06f7";
	
	private int total_energy;
	private int total_protein;
	private int total_carbs;
	private int total_fat;
	
	private Double energyValue;
	private Double proteinValue;
	private Double fatValue;
	private Double carbsValue;
	
	public FoodDatabaseService() {
		
		total_energy=0;
		total_protein=0;
		total_carbs=0;
		total_fat=0;

	}
	public int getAverage(int total, int num) {
		
		int average = (int) total/num;
		
		return average;
	}
	
	
	public String searchFood(String keyword) throws IOException {
		
		StringBuilder theOutput=new StringBuilder();
		
		System.out.println(keyword);
		
		HttpURLConnection conn = null;
		StringBuilder jsonResults = new StringBuilder();
		
		StringBuilder sbRequest = new StringBuilder();
		sbRequest.append(FOOD_DATABASE_URL);
		sbRequest.append("?");
		
     
		sbRequest.append("ingr=" + URLEncoder.encode(keyword, "utf8"));
	
        sbRequest.append("&app_id=" + API_ID);
        sbRequest.append("&app_key=" + API_KEY);
    	
    //	System.out.println(sbRequest);
        
    	//create url object
        URL url = new URL(sbRequest.toString());
        conn = (HttpURLConnection) url.openConnection();
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        
        int read;
        char[] buff = new char[4096];
        while ((read = in.read(buff)) != -1) {
        //	System.out.println("JSON response bytes:" + read);
            jsonResults.append(buff, 0, read);
        }
		
        if (conn != null) {
            conn.disconnect();
        }
        
        
        JSONObject jsonObj = new JSONObject(jsonResults.toString());
    //    System.out.println(jsonObj);
    //    System.out.println(jsonObj.length());
       
        //get hints array
        JSONArray predsJsonArray = jsonObj.getJSONArray("hints");
        //print hints array size
    //    System.out.println(predsJsonArray.length());
        
      //  System.out.println(predsJsonArray);
        int arraySize = predsJsonArray.length();
        
        for(int index=0; index < arraySize; index++)
        {
        	JSONObject food = (JSONObject) predsJsonArray.getJSONObject(index).get("food");
        
        	//System.out.println(food.get("nutrients"));
        	//JSONObject foodLabel = (JSONObject) food.get("label");
        //	System.out.println(foodLabel);
        	JSONObject foodNutrients = (JSONObject) food.get("nutrients");
        	//System.out.println(food.getJSONObject("nutrients"));
        	
        //	System.out.println(foodNutrients);
        	int nutrient_size = foodNutrients.length();
        	//System.out.println(nutrient_size);
        	
        	Set<String> nutrientLabelList = foodNutrients.keySet();
        	Object[] a = new Object[nutrient_size];
        	a = nutrientLabelList.toArray();
        	String c=null;
        	for (Object b : a) {
        		
        		c = (String) b;
            //	System.out.println(c);
            	
               	if(c.equals("ENERC_KCAL")) {
            		
            		energyValue =  (Double) foodNutrients.get("ENERC_KCAL");
            		total_energy += Math.round(energyValue);
            		
            	}else if(c.equals("PROCNT")) {
            		
            		proteinValue = (Double) foodNutrients.get("PROCNT");
            		total_protein += Math.round(proteinValue);
            		
            	}else if(c.equals("FAT")) {
            		
            		fatValue = (Double)foodNutrients.get("FAT");
            		total_fat += Math.round(fatValue);
            		
            	}else if(c.equals("CHOCDF")) {
            		
            		carbsValue = (Double)foodNutrients.get("CHOCDF");
            		total_carbs += Math.round(carbsValue);
            		
            	}
            	
        	}      
       	
        }//end for
        
        
        int average_energy = getAverage(total_energy, arraySize);
        int average_protein = getAverage(total_protein, arraySize);
        int average_carbs = getAverage(total_carbs, arraySize);
        int average_fat = getAverage(total_fat, arraySize);
        
        theOutput.append("Nutrition Facts: ");
        theOutput.append("Energy- " + average_energy +" kcal");
        theOutput.append(", ");
        theOutput.append("Protein- " + average_protein+" g");
        theOutput.append(", ");
        theOutput.append("Fat- " + average_fat+" g");   
        theOutput.append(", ");
        theOutput.append("Carbs- " + average_carbs+" g");
        
      /*  System.out.print("Nutrition Facts: ");
        
    	System.out.print("Energy- " + average_energy +" kcal");
    	System.out.print(" ");
    	System.out.print("Protein- " + average_protein+" g");
    	System.out.print(" ");
    	System.out.print("Fat- " + average_fat+" g");
    	System.out.print(" ");
    	System.out.println("Carbs- " + average_carbs+" g");
    	*/
		
		total_energy=0;
		total_protein=0;
		total_carbs=0;
		total_fat=0;
        
		return theOutput.toString();
		
	}//end method

}
