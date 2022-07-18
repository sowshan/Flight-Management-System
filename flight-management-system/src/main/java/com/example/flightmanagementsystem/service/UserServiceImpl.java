package com.example.flightmanagementsystem.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<User> viewUser(String userId) {
		Optional<User> findById = usr.findById(userId);
		//try {
			if (findById.isPresent()) {
				User findUser = findById.get();
				return new ResponseEntity<User>(findUser, HttpStatus.OK);
			} else
				//throw new RecordNotFoundException("No record found with ID " + userId);
		//} catch (RecordNotFoundException e) {
			return new ResponseEntity<User>( HttpStatus.NOT_FOUND);
		//}
	}
		
	
	@Override
	public User updateUser(User user) {
		return usr.save(user);
		 
	}
	
	@Override
	public Boolean removeUser(String userId) {
		if(usr.existsById(userId)) {
			User user = usr.getReferenceById(userId);
			if(user.getUserType()=="Admin") {
			usr.deleteById(userId);
		
			return true;}}
		return false;
	
	}
	public Boolean login(String userId,String password) {
		if(usr.existsById(userId) ) {
			User user = usr.getReferenceById(userId);
			if(user.getPassword()==password) {
				return true;
			}
			
		}
	return false;
	}

}
