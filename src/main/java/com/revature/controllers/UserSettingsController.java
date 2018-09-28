package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.models.forms.ChangeSettingsForm;
import com.revature.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserSettingsController {
	
	@Autowired
	UserService userService;
	
	//list all users with localhost:8080/users
	@GetMapping(produces="application/json")
	public List<User> listAllUsers()
	{
		return userService.listAllUsers();
	}
	
	//post, create a user
	@PostMapping(consumes="application/json", produces="application/json")
	public User createUser(@RequestBody User newUser)
	{
		return userService.createUser(newUser);
	}
	
	//put, update user
	@PutMapping(consumes="application/json", produces="application/json")
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
