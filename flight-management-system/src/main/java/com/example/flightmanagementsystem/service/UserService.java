package com.example.flightmanagementsystem.service;

import java.math.BigInteger;
import java.util.Optional;

import com.example.flightmanagementsystem.entity.User;
//import com.example.flightmanagementsystem.repository.UserNotFoundException;

public interface UserService {
	public User addUser(User user);
	public Optional<User> viewUser(String userId); //throws UserNotFoundException;
	public User updateUser(User user) ;//throws UserNotFoundException;
	public Boolean removeUser(String UserId) ;//throws UserNotFoundException;
}
