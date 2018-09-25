package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;

@RestController
@RequestMapping("/session")
@CrossOrigin
public class SessionController {
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public String[] getCurrentUser(HttpServletRequest request) {
		HttpSession s = request.getSession();
		String[] credentials = { (String) s.getAttribute("userN"), (String) s.getAttribute("passW"), (String) s.getAttribute("name")};
		return credentials;
	}

}
