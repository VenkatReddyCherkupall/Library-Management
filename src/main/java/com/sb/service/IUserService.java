package com.sb.service;

import java.util.List;

import com.sb.beans.User;

public interface IUserService {

	public User addUser(User user);
	public List<User> getAllUsers();
}

