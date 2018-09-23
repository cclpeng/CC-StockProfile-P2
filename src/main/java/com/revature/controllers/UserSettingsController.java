package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.revature.models.User;
import com.revature.models.forms.ChangeSettingsForm;
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
	
	//doing POST localhost:8094/settings will do our post(into db) if we provide a body (like in postmaster)
	//not quite sure how to link to the form on the front end side however
	@PostMapping(consumes="application/json", produces="application/json")
	public String changePassword(@RequestBody ChangeSettingsForm form) { 
		User u = userService.verifyUser(form.getUsername(), form.getOldPassword());
		if( u != null && (form.getNewPassword().equals( form.getConfirmPassword() )) )
		{
			u.setPassW(form.getNewPassword());
			userService.updateUser(u); 
		}										
		return "redirect:/settings";	//becuz either way is redirecting back to settings, must check ur db 
	}
	/*EXAMPLE QUERY TO PUT IN POSTMASTER:
		{
		"username":"cindy",
		"oldPassword":"p",
		"newPassword":"pass",
		"confirmPassword:"pass"
		}
	
	*/
		
	
	
}
