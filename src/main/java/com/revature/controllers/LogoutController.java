package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logout")
@CrossOrigin
public class LogoutController {
	
	//for now...dummy method
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public String[] invalidateSession(HttpServletRequest request) {
		HttpSession s = request.getSession();
		s.setAttribute("userN", null);
		s.setAttribute("passW", null);
		s.setAttribute("name", null);
		String[] credentials = {(String)s.getAttribute("userN"), (String)s.getAttribute("passW"), (String)s.getAttribute("name")}; 
		if(request.getSession() != null) {
			s.invalidate();
		}
		System.out.println("Went to GET /logout to invalidate session");
		return credentials;
	}
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public String[] getCurrentUser(HttpServletRequest request) {
		HttpSession s = request.getSession();
		s.setAttribute("userN", null);
		s.setAttribute("passW", null);
		s.setAttribute("name", null);
		String[] credentials = {(String)s.getAttribute("userN"), (String)s.getAttribute("passW"), (String)s.getAttribute("name")}; 
		if(request.getSession() != null) {
			s.invalidate();
		}
		return credentials;
	}

}
