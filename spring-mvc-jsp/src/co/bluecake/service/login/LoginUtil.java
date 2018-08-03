package co.bluecake.service.login;

import java.io.IOException;

import co.bluecake.users.User;



public class LoginUtil {
	
	/**********************************************************
	* Call User & password validation
	***********************************************************/
	public static boolean VerifyUser(User theUser) {
		
		boolean isMatch = VerifyProvidedPassword(theUser.getName(), theUser.getPassword());
		
		return isMatch;
	}
	
	
	/**********************************************************
	* Validate User & Password 
	***********************************************************/
	public static boolean VerifyProvidedPassword(String providedUserName,
												String providedPassword ) {
	 
			boolean returnValue=false;
			
			System.out.println(providedUserName);
			System.out.println(providedPassword);
	        
	        String securePassword=null, salt=null;
	        try {
				String[] results = PswDatabaseUtil.fetchData(providedUserName);
				//results contains: userName, secure password, salt value
				 securePassword = results[1];
				 salt =results[2];
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);
	        
	        if(passwordMatch) 
	        {
	            System.out.println("Provided user password " + providedPassword + " is correct.");
	            returnValue=true;
	        
	        } else {
	            System.out.println("Provided password/user name is incorrect");            
	        }
	        
	        //true=match, false=no match 
	        return returnValue;
	    }
	

		/**********************************************************
		 * call web api service
		 ***********************************************************/
		public static void getWebApi() {
		
		
			}
}
