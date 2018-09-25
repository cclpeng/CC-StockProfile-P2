package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.revature.models.User;
import com.revature.models.forms.ChangeSettingsForm;
import com.revature.services.UserService;

@CrossOrigin
@Controller
@RequestMapping("/users")
public class UserSettingsController {
	
	@Autowired
	UserService userService;
	
	//doing PUT localhost:8080/users will do our post(into db) if we provide a body (like in postmaster)
	@PutMapping(consumes="application/json", produces="application/json")
	@ResponseBody
	public User changePassword(@RequestBody ChangeSettingsForm form) { 
		User u = userService.verifyUser(form.getUsername(), form.getOldPassword());
		if( u != null && (form.getNewPassword().equals( form.getConfirmPassword() )) )
		{
			u.setPassW(form.getNewPassword());
			return userService.updateUser(u); 
		}										
		return null;	//becuz either way is redirecting back to settings, must check ur db 
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
