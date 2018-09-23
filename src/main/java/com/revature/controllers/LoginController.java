package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.revature.services.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public RedirectView loginPage() {
		//hehehhhh  :https://stackoverflow.com/questions/17955777/redirect-to-an-external-url-from-controller-action-in-spring-mvc
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("http://cc-stockprofile-p2.com.s3-website-us-east-1.amazonaws.com/login");
	    return redirectView;
	}
	
	@PostMapping
//	public RedirectView loginValidationRedirection(@RequestBody String username, @RequestBody String password)
	public RedirectView loginValidationRedirection()
	{
		RedirectView redirectView = new RedirectView();
		//set up a session with those params
//		if(username.equals("cindy") && password.equals("pass"))
		redirectView.setUrl("http://cc-stockprofile-p2.com.s3-website-us-east-1.amazonaws.com/home");
//		else
//			redirectView.setUrl("http://cc-stockprofile-p2.com.s3-website-us-east-1.amazonaws.com/login");
//		return redirectView;
		
		return redirectView;
	}
	
}
