package com.example.flightmanagementsystem.service;



import org.springframework.http.ResponseEntity;

import com.example.flightmanagementsystem.entity.User;

public interface UserService {
	public Boolean login(String userId,String password);
	public  User addUser(User user); 
	public ResponseEntity<User> viewUser(String userId); //throws UserNotFoundException;
	public User updateUser(User user) ;//throws UserNotFoundException;
	public Boolean removeUser(String UserId) ;//throws UserNotFoundException;
}
