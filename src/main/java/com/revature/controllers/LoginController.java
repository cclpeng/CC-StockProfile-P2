package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.revature.models.User;
import com.revature.models.forms.LoginForm;
import com.revature.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
//	@GetMapping
//	public RedirectView loginPage() {
//		//hehehhhh  :https://stackoverflow.com/questions/17955777/redirect-to-an-external-url-from-controller-action-in-spring-mvc
//		RedirectView redirectView = new RedirectView();
//	    redirectView.setUrl("http://cc-stockprofile-p2.com.s3-website-us-east-1.amazonaws.com/login");
//	    return redirectView;
//	}
	
	@GetMapping
	public String[] dummyLogin (HttpServletRequest request) {
		HttpSession s = request.getSession();    
		s.setAttribute("userN", "cindy");
		s.setAttribute("passW", "p");
		s.setAttribute("name", "cindy peng");  
		String[] credentials = new String[3];
		credentials[0] = (String) s.getAttribute("userN");
		credentials[1] = (String) s.getAttribute("passW");
		credentials[2] = (String) s.getAttribute("name");
		return credentials;
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User loginValidationRedirection(@RequestBody LoginForm loginForm, HttpServletRequest request)
	{
		User user = userService.verifyUser(loginForm.getUsername(), loginForm.getPassword());
		if(user != null)
		{
			HttpSession s = request.getSession();    
			s.setAttribute("userN", user.getUserN());
			s.setAttribute("passW", user.getPassW());
			s.setAttribute("name", user.getName());  
			//
			System.out.println(s.getId());
			//testing the session
			System.out.println("-    -   -     SESSION SET   -    -    -");
			System.out.println(s.getAttribute("userN"));
		}
		return user;
	}
	
}
