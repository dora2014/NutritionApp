package co.bluecake.springdemo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.bluecake.service.demo.GenericWelcomeService;
import co.bluecake.service.demo.WelcomeService;
import co.bluecake.service.login.LoginUtil;
import co.bluecake.service.search.SearchFoodUtil;
import co.bluecake.service.signup.SignUpUtil;
import co.bluecake.users.User;
import co.bluecake.users.UserValidate;

@Controller
public class WelcomeController {
	
	@Autowired
	private GenericWelcomeService welcomeService;
	
	@RequestMapping(value="searchFood", method=RequestMethod.GET) //handler method upon request
	public String foodSearch(@ModelAttribute("foodString")String theFood,
							Model model) {
		
		System.out.println(theFood);
		
		//retrieving processed data
		String result = SearchFoodUtil.search(theFood);
	//	String userTitle = welcomeService.getUserNameMsg(theUser);
			
		//add data to the model(data container)	
		model.addAttribute("foodName", theFood);
		model.addAttribute("foodResultVAlue", result);
		model.addAttribute("foodResultStatus", "YES");
		//return response info to the view
		//logical view name
		return "FoodResultDisplay";  //internal resource resolver
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST) //handler method upon request
	public String login(@ModelAttribute("userName")String user,
						@ModelAttribute("password")String psw,	
						Model model) {
		
	//	System.out.println(user);
	//	System.out.println(psw);
		
		List<String> welcomeMessage=null;
		String resultMsg="No User found! Please Try Again";
		
		//retrieving username, password from the system
		//validate if user exist or new user
		User processUser = new User(user, psw);	
		
		if(LoginUtil.VerifyUser(processUser)) 
		{
			welcomeMessage = welcomeService.getWelcomeMsg(user);
			//add data to the model(data container)
			model.addAttribute("myWelcomeMessage", welcomeMessage);	
			model.addAttribute("userID", user);
			model.addAttribute("loginStatus", "OK");
			
			/**************************************************************
			 * if verify login, user can search food in dashboard page
			 *************************************************************/
			
			
		}else {
			model.addAttribute("myWelcomeMessage", resultMsg);	
			model.addAttribute("loginStatus", "Failed");
		}
		
	
		//return response info to the view
		//logical view name
		return "WelcomeNew";  //internal resource resolver
		
	}
	
	@RequestMapping(value="signUpUser", method=RequestMethod.POST) //handler method upon request
	public String signUp(@ModelAttribute("userName")String userId,
							@ModelAttribute("password")String password,
							@ModelAttribute("firstName")String first_name,
							@ModelAttribute("lastName")String last_name,
							@ModelAttribute("zipCode")String zip_code,
							Model model) 
	{
		String failedMsg;
		
		try {
			
			//if successful signup
			if(SignUpUtil.NewUser(userId, password))
			{
				
				List<String> welcomeMessage = welcomeService.getWelcomeMsg(first_name);
				String fullName = first_name+" " +last_name;
				//add data to the model(data container)			
				model.addAttribute("myWelcomeMessage", welcomeMessage);
				
				model.addAttribute("userID", userId);
				model.addAttribute("psw", password);
				model.addAttribute("fullName",fullName);
				model.addAttribute("zip", zip_code);	
				model.addAttribute("signUpStat", "OK");
				
			}else {//not successful
				
				failedMsg="User Already Exists!";
				model.addAttribute("myWelcomeMessage", failedMsg);
				model.addAttribute("signUpStat", "Failed");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

				
		//return response info to the view
		//logical view name
		return "WelcomeNew";  //internal resource resolver
		
	}
	
	

}
