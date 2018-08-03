package co.bluecake.service.demo;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService implements GenericWelcomeService {

	public List<String> getWelcomeMsg(String theName) {
		
		List<String> theList = new ArrayList<String>();
		
		theList.add("Welcome ");
		theList.add("to Master Nutrition! ");
		theList.add(theName);
		
		return theList;
		
	}

	@Override
	public String getUserNameMsg(String name) {
		
		return name+" Dashboard";
	}
	
	
	
	
}

