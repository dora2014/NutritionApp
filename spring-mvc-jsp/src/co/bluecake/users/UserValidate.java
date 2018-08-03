package co.bluecake.users;

import java.util.ArrayList;
import java.util.List;

public class UserValidate {
	
	private static List<User> userList = new ArrayList<User>();
	
	//read a list of users from the file to userList
	public static void getUserList() {
		
		System.out.println(System.getProperty("user.dir"));
		
	}
	
	public static boolean isUserExist(User theUser) {
		
		boolean isExist=false;
		
		for(User eachUser: userList) {
			
		//	(eachUser.getName()).equals(theUser.getName());
			if(eachUser.equals(theUser)) {
				isExist=true;
			}		
		}//end for
		
		return isExist;
		
	}

}
