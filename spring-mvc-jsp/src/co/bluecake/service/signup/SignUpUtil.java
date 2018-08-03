package co.bluecake.service.signup;

import java.io.IOException;
import java.util.Scanner;

import co.bluecake.service.login.PasswordUtils;
import co.bluecake.service.login.PswDatabaseUtil;


public class SignUpUtil {

	
	public static boolean userNameConflict(String userName) throws IOException {
		
		boolean conflict=false;  //username conflict
        boolean newSignUp=false;  //new signup flag
        
	
	   //check if user name already taken
	   if(PswDatabaseUtil.isAlreadyExist(userName)) 
	   {	    	
		   conflict = true ;
	       System.out.println("User Name Already Exist...");
	        	
	   }
	   
	   return conflict;
		
	}
	
	
	/************************************************
	*Protect User Password Code Example in Java
	 * @throws IOException 
	*************************************************/
	public static boolean NewUser(String userName ,
							String myPassword) throws IOException {
	        boolean signUpStatus=false;
	       
	        //check if user name already taken
	        if(!userNameConflict(userName)) //if no user name conflict
	        {
	            // Generate Salt. The generated value can be stored in DB. 
		        String salt = PasswordUtils.getSalt(30);
		        
		        // Protect user's password. The generated value can be stored in DB.
		        String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);
	        	
		        PswDatabaseUtil.storeData(userName, mySecurePassword,salt);
		        signUpStatus=true;
		        
	        }
	        
	        return signUpStatus;
	  
	}
	
	
	
}
