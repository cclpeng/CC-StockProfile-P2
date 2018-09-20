package com.revature.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
	
	@GetMapping(value="/home", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String displayMessage() {
		return "Hello from our CC Boot App";
	}
	
	@GetMapping(value="/login")
	public RedirectView loginPage() {
		//hehehhhh  :https://stackoverflow.com/questions/17955777/redirect-to-an-external-url-from-controller-action-in-spring-mvc
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("http://com.revature.cireycindystock.s3-website-us-east-1.amazonaws.com/");
	    return redirectView;
	}
	
}
