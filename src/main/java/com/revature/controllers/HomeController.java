package com.revature.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping(value = "/login")
	public String getHome() {
		return "http://com.revature.cireycindystock.s3-website-us-east-1.amazonaws.com/";
	}

}
