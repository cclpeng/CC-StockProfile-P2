package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	public List<User> getUsers();
	public User getUserById(int id);
	public int createUser(User user);
	public void updateUser(User user);
	public void deleteUserById(int id);
}
