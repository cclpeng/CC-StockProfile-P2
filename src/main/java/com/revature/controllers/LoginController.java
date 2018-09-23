package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.revature.models.LoginTry;
import com.revature.models.User;
import com.revature.services.UserService;

@Controller
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
	
//	@PostMapping(value="/login", params= {"username", "password"})
//	public RedirectView loginValidationRedirection(@RequestParam("username") String userN, 
//												   @RequestParam("password") String passW)
//	{
//		RedirectView redirectView = new RedirectView();
//		User user = userService.loginUser(userN, passW); 
//		if(user != null)
//			redirectView.setUrl("http://cc-stockprofile-p2.com.s3-website-us-east-1.amazonaws.com/home");
//		else
//			redirectView.setUrl("http://cc-stockprofile-p2.com.s3-website-us-east-1.amazonaws.com/login");
//		return redirectView;
//		
//	}
	@PostMapping(value="/login", consumes="application/json", produces=MediaType.APPLICATION_JSON_VALUE)
	public RedirectView loginValidationRedirection(@RequestBody LoginTry loginForm)
	{
		
		RedirectView redirectView = new RedirectView();
		User user = userService.verifyUser(loginForm.getUsername(), loginForm.getPassword()); 
		if(user != null) 
			redirectView.setUrl("http://cc-stockprofile-p2.com.s3-website-us-east-1.amazonaws.com/home");
		else
			redirectView.setUrl("http://cc-stockprofile-p2.com.s3-website-us-east-1.amazonaws.com/login");
		return redirectView;
	}
	
}
