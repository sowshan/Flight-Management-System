package com.example.flightmanagementsystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.flightmanagementsystem.entity.User;
import com.example.flightmanagementsystem.exceptions.InvalidCredentialsException;
import com.example.flightmanagementsystem.exceptions.RecordNotFoundException;
import com.example.flightmanagementsystem.repositories.UserRepo;

@Service

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo usr;

	@Override
	public String addUser(User user) {
		if(user.getPassword().isEmpty()|| user.getUserType().isEmpty()|| user.getPhoneNo().isEmpty()|| user.getUserEmail().isEmpty()|| user.getUserName().isEmpty()) {
			return "Please fill all feilds";
		}
		else {
			usr.save(user);
			return "User Added Successfully";
		}
	}

	@Override
	public Object viewUser(String userId) throws RecordNotFoundException {
		if (usr.existsById(userId)) {
			return usr.findByUserId(userId);
		}
		else
			return "UserID Not Found";
	}

	@Override
	public boolean removeUser(String userId) {
		if (usr.existsById(userId)) {
			User user = usr.getReferenceById(userId);
			// if (user.getUserType() == "Admin") {
			usr.deleteById(userId);
			return true;
			// }
		} else {
			return false;
			// throw new RecordNotFoundException("Record not found");
		}

	}

	public String login(String userId, String password) throws InvalidCredentialsException {
		if (usr.existsById(userId)) {
			User user = usr.getReferenceById(userId);
			if (user.getPassword().equals(password)) {
				return "Successful login";
			}
		}
		return "Please Check Credentials";
		//throw new InvalidCredentialsException("Please Check Credentials");
	}

	@Override
	public User updateUser(User user) {
		return usr.save(user);
	}
	
}
