package co.bluecake.service.demo;

import java.util.List;

public interface GenericWelcomeService {
	
	public List<String> getWelcomeMsg(String name);
	
	public String getUserNameMsg(String name);
	
}
