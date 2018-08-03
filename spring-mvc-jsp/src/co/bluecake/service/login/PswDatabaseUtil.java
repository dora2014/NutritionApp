package co.bluecake.service.login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PswDatabaseUtil {

	private static final String USER ="Waising";  //enter local user name
	
	private static final String default_file="C:\\Users\\"+ USER +"\\Desktop\\psw_data.txt";
	
	public static boolean isAlreadyExist(String user) throws IOException {
		String lineContent;
		boolean foundMatch=false;
		
		BufferedReader buff = new BufferedReader(new FileReader(default_file));
		while ((lineContent = buff.readLine()) !=null)
    	{
			if(lineContent.contains(user)) {
				foundMatch =true;
				break;
			}
    	}
		
		return foundMatch;
		
	}
	
    public static void storeData(String un, String psw, String salt) throws IOException {
    	
    	System.out.println(un);
    	StringBuilder theString = new StringBuilder();
    	
    	if(!isAlreadyExist(un)) 
    	{
    		   	
    		theString.append(un);
    		theString.append(",");
    		theString.append(psw);
    		theString.append(",");
    		theString.append(salt);
    		System.out.println("save password to database file.....");
    		
    		File newfile = new File(default_file);
    	
    		FileWriter filew = new FileWriter(newfile, true);
    		BufferedWriter buffw = new BufferedWriter(filew);  
	    	
    		buffw.write(theString.toString()); 
    		buffw.newLine();  //separate the line

    		buffw.close();
	    
    	}
    }
    
    public static String[] fetchData(String user) throws IOException{
    	String lineContent;
    	String[] theData = new String[3];
    	boolean matched=false;
    	
    	BufferedReader buff = new BufferedReader(new FileReader(default_file));
    	
    	while ((lineContent = buff.readLine()) !=null)
    	{
    		if(lineContent.contains(user)) {
    			
    			theData = lineContent.split(",");
    			matched=true;
    			break;
    		}
    		  			
    	} 	

    	//if username not found! 
    	if(!matched)
    	{
    		 System.out.println("No user name match!...Bye....."); 
    		 theData[0] = "DEFAULT";
    		 theData[1] = "DEFAULT";
    		 theData[2] = "DEFAULT";
    	}
		
    	return theData;
    	
    }
    
	
	
}
