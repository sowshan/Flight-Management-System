package com.example.flightmanagementsystem.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightmanagementsystem.entity.User;
import com.example.flightmanagementsystem.repository.UserRepo;


@Service

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo usr;
	
	@Override
	public User addUser(User user) {
		return usr.save(user);
	}
	
	@Override
	public Optional<User> viewUser(String userId) {
		return usr.findById(userId);
		}
		
	
	@Override
	public User updateUser(User user) {
		return usr.save(user);
		 
	}
	
	@Override
	public Boolean removeUser(String userId) {
		if(usr.existsById(userId)) {
			usr.deleteById(userId);
		
			return true;}
		return false;
	
	}
}
