package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/session")
public class SessionController {
	
//	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
//	public String[] getCurrentUser(HttpServletRequest request) {
//		HttpSession s = request.getSession();
//		String[] credentials = { (String) s.getAttribute("userN"), (String) s.getAttribute("passW"), (String) s.getAttribute("name")};
//		return credentials;
//	}
	@GetMapping(produces="application/json")
	public String[] getGetCurrentUser(HttpServletRequest request)
	{
		HttpSession s = request.getSession(false);
		if(s == null) {
			String[] array = new String[3];
			array[0] = "nooo";
			array[1] = "badd";
			array[2] = "sessionn";
			System.out.println("Went to GET /sessions. BUT NO SESSION :(");
			return array;}
		String[] credentials = { (String) s.getAttribute("userN"), (String) s.getAttribute("passW"), (String) s.getAttribute("name")};
		
		System.out.println("Went to GET /sessions. here is session username: "+credentials[0]);
		return credentials;
	}
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public String[] getCurrentUser(HttpServletRequest request) {
		HttpSession s = request.getSession(false);
		if(s == null) {
			String[] array = new String[3];
			array[0] = "nooo";
			array[1] = "bad";
			array[2] = "session";
			System.out.println("Went to GET /sessions. BUT NO SESSION :(");
			return array;}
		String[] credentials = { (String) s.getAttribute("userN"), (String) s.getAttribute("passW"), (String) s.getAttribute("name")};
		
		System.out.println("Went to POST /sessions. here is session username: "+credentials[0]);
		return credentials;
	}

}
