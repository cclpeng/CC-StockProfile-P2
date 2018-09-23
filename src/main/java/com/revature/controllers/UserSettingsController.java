package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.revature.services.UserService;

@Controller
@RequestMapping("/settings")
public class UserSettingsController {
	
	@Autowired
	UserService userService;
	
	@GetMapping()
	public RedirectView goToUserSettingsView() {
		
		RedirectView rv = new RedirectView();
		rv.setUrl("http://cc-stockprofile-p2.com.s3-website-us-east-1.amazonaws.com/settings");
		return rv;
	}
	
	@PostMapping
	public RedirectView goToUserS() {
		RedirectView rv = new RedirectView();
		rv.setUrl("http://cc-stockprofile-p2.com.s3-website-us-east-1.amazonaws.com/login");
		return rv;
	}
	
	
}
