package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepo;

	@Override
	public List<User> listAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepo.getOne(id);
	}

	@Override
	public User createUser(User newUser) {
		return userRepo.save(newUser);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepo.delete(user);
	}

	@Override
	public User verifyUser(String username, String password) {
		return userRepo.findUserByUserNAndPassW(username, password);
	}
}
