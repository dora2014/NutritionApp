package co.bluecake.service.search;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class SearchFoodUtil 
{
	
    public static String search(String searchWord)
    {
        System.out.println( "Welcome to Master Nutrition!" );
        String searchResult = null;
        
        FoodDatabaseService thefoodData = new FoodDatabaseService();
        try {
        	 System.out.println("Food*******************");
        	 searchResult = thefoodData.searchFood(searchWord);
        	 
			Thread.sleep(500);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
        return searchResult;
    }
}
