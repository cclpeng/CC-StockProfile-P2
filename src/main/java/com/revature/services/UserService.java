package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.User;

@Service
public interface UserService {
	
	public List<User> listAllUsers();
	public User getUserById(Long id);
	public User createUser(User newUser);
	public User updateUser(User user);
	public void deleteUser(User user);
	public User verifyUser(String username, String password);
}
