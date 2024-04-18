package com.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.Repo.IUserRepo;
import com.sb.beans.User;

@Service
public class UserServiceImpl implements IUserService {

	
	@Autowired
	private IUserRepo userRepo;
	
	@Override
	public User addUser(User user) {

		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}

}
