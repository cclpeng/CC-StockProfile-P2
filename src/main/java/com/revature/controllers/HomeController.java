package com.revature.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
	
	@GetMapping(value = "/login")
	public String getHome() {
		return "http://com.revature.cireycindystock.s3-website-us-east-1.amazonaws.com/";
	}
	
	@GetMapping(value="/login")
	public RedirectView loginPage() {
		//hehehhhh  :https://stackoverflow.com/questions/17955777/redirect-to-an-external-url-from-controller-action-in-spring-mvc
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("http://cc-stockprofile-p2.com.s3-website-us-east-1.amazonaws.com/login");
	    return redirectView;
	}
	
	@PostMapping(value="/login", consumes=MediaType.TEXT_PLAIN_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public RedirectView loginValidationRedirection(@RequestBody String username)
	{
		System.out.println(username); //see if we can get those params :DD
		//set up a session with those params
		RedirectView redirectView = new RedirectView();
//	    redirectView.setUrl("http://com.revature.cireycindystock.s3-website-us-east-1.amazonaws.com/home");
		redirectView.setUrl("http://cc-stockprofile-p2.com.s3-website-us-east-1.amazonaws.com/login");
	    return redirectView;
	}
	
}
